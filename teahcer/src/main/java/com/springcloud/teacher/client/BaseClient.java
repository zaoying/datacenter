package com.springcloud.teacher.client;

import com.springcloud.teacher.dto.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author huangzurong
 */
public interface BaseClient<T,ID> {
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    Response<T> findById(@PathVariable("id") ID id);
}
