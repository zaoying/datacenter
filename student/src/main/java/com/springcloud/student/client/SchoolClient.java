package com.springcloud.student.client;

import com.springcloud.student.dto.Response;
import com.springcloud.student.dto.School;
import com.springcloud.student.fallback.SchoolClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author huangzurong
 */
@FeignClient(name = "school-service", fallback = SchoolClientFallback.class)
public interface SchoolClient extends BaseClient<School,Long>{
    @RequestMapping(value = "/school/get/{id}", method = RequestMethod.GET)
    Response<School> findById(@PathVariable("id") Long id);
}
