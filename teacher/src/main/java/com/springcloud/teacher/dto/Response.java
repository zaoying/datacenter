package com.springcloud.teacher.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloud.teacher.utils.Status;

import java.util.Optional;

/**
 * @author huangzurong
 */
public class Response<T> extends Status {

    public boolean isSucceed(){
        return getCode() == SUCCESS_STATE;
    }

    public Optional<T> getBean(String name){
        Object object = get(name);
        T value = null;
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            value = objectMapper.convertValue(object, new com.fasterxml.jackson.core.type.TypeReference<T>(){});
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return Optional.ofNullable(value);
    }
}
