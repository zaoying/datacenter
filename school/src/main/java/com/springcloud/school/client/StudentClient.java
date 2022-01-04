package com.springcloud.school.client;

import com.springcloud.school.dto.Response;
import com.springcloud.school.dto.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author huangzurong
 */
@FeignClient(name = "student-service")
public interface StudentClient extends BaseClient<Student,Long>{
    @Override
    @RequestMapping(value = "/student/get/{id}", method = RequestMethod.GET)
    Response<Student> findById(@PathVariable("id") Long id);
}
