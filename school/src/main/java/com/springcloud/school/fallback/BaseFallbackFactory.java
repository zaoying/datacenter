package com.springcloud.school.fallback;

import feign.hystrix.FallbackFactory;

/**
 * @author huangzurong
 */
public class BaseFallbackFactory<T,ID> implements FallbackFactory<BaseClientFallback<T,ID>> {
    @Override
    public BaseClientFallback<T,ID> create(Throwable throwable) {
        return null;
    }
}
