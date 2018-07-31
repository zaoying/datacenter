package com.springcloud.school.fallback;

import feign.hystrix.FallbackFactory;

/**
 * @author huangzurong
 */
public class BaseFallbackFactory implements FallbackFactory<BaseClientFallback> {
    @Override
    public BaseClientFallback create(Throwable throwable) {
        return null;
    }
}
