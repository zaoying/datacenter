package com.springcloud.teacher.utils;

import java.util.Optional;

/**
 * @author huangzurong
 */
public class ClassUtil {

    public static <T> Optional<T> newInstance(Class<T> clazz){
        T instance = null;
        try {
            instance = clazz.getConstructor(clazz).newInstance();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(instance);
    }
}
