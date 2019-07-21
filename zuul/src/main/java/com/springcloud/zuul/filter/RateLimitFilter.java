package com.springcloud.zuul.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;

import static org.springframework.http.HttpStatus.TOO_MANY_REQUESTS;

/**
 * @author huangzurong
 */
public class RateLimitFilter extends ZuulFilter {

    private RateLimiter rateLimiter = RateLimiter.create(10000);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        if (!rateLimiter.tryAcquire()) {
            RequestContext ctx = RequestContext.getCurrentContext();
            ctx.setResponseStatusCode(TOO_MANY_REQUESTS.value());
            ctx.put("rateLimitExceeded", "true");
            throw new ZuulRuntimeException(new ZuulException(TOO_MANY_REQUESTS.toString(),
                TOO_MANY_REQUESTS.value(), null));
        }
        return null;
    }
}
