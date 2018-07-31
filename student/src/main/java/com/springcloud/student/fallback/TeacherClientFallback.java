package com.springcloud.student.fallback;


import com.springcloud.student.client.TeacherClient;
import com.springcloud.student.dto.Teacher;
import org.springframework.stereotype.Component;

/**
 * @author huangzurong
 */
@Component
public class TeacherClientFallback extends BaseClientFallback<Teacher,Long> implements TeacherClient {
}
