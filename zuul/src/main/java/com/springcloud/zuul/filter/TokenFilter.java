package com.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.FORBIDDEN;


/**
 * @author huangzurong
 */
public class TokenFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)){
            //认证失败
            System.out.println("token验证失败");

            ctx.setResponseStatusCode(FORBIDDEN.value());
            ctx.put("rateLimitExceeded", "true");
            throw new ZuulRuntimeException(new ZuulException(FORBIDDEN.toString(),
                    FORBIDDEN.value(), null));
        }
        System.out.println("token验证成功");
        return null;
    }
}
