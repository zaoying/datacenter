package com.springcloud.teacher.fallback;

import com.springcloud.teacher.client.StudentClient;
import com.springcloud.teacher.dto.Response;
import com.springcloud.teacher.dto.Student;
import org.springframework.stereotype.Component;

/**
 * @author huangzurong
 */
@Component
public class StudentClientFallback extends BaseClientFallback<Student,Long> implements StudentClient {
    @Override
    public Response<Student> findByIdFallback(Long id) {
        Response<Student> response = new Response<>();
        response.setCode(Response.INTERNAL_ERROR);
        response.setMessage("请求失败：网络错误");
        response.put("student",new Student());
        return response;
    }
}
