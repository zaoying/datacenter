package com.springcloud.student.client;

import com.springcloud.student.dto.Response;
import com.springcloud.student.dto.Teacher;
import com.springcloud.student.fallback.TeacherClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author huangzurong
 */
@FeignClient(name = "teacher-service", fallback = TeacherClientFallback.class)
public interface TeacherClient extends BaseClient<Teacher,Long>{
    @Override
    @RequestMapping(value = "/teacher/get/{id}", method = RequestMethod.GET)
    Response<Teacher> findById(@PathVariable("id") Long id);
}
