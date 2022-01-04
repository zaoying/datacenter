package com.springcloud.school.client;

import com.springcloud.school.dto.Response;
import com.springcloud.school.dto.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author huangzurong
 */
@FeignClient(name = "teacher-service")
public interface TeacherClient extends BaseClient<Teacher,Long>{
    @Override
    @RequestMapping(value = "/teacher/get/{id}", method = RequestMethod.GET)
    Response<Teacher> findById(@PathVariable("id") Long id);
}
