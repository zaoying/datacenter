package com.springcloud.teacher.client;

import com.springcloud.teacher.dto.Response;
import com.springcloud.teacher.dto.Student;
import com.springcloud.teacher.fallback.StudentClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author huangzurong
 */
@FeignClient(name = "student-service", fallback = StudentClientFallback.class)
public interface StudentClient extends BaseClient<Student,Long>{
    @Override
    @RequestMapping(value = "/student/get/{id}", method = RequestMethod.GET)
    Response<Student> findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    Response<Student> findByIdFallback(@PathVariable("id") Long id);
}
