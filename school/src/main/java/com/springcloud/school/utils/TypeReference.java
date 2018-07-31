package com.springcloud.school.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author huangzurong
 */
public class TypeReference<T> {

    private Class<T> actualClass;

    public TypeReference() {
        Type type = getClass()
                .getDeclaringClass()
                .getGenericSuperclass();
        if(type instanceof ParameterizedType){
            Type[] types = ((ParameterizedType)type).getActualTypeArguments();
            actualClass = (Class<T>) types[0];
        }
        actualClass = (Class<T>) type;
    }

    public TypeReference(Class<T> actualClass) {
        this.actualClass = actualClass;
    }

    public Class<T> getActualClass() {
        return actualClass;
    }
}
