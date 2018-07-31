package com.springcloud.school.fallback;

import com.springcloud.school.client.TeacherClient;
import com.springcloud.school.dto.Teacher;
import org.springframework.stereotype.Component;

/**
 * @author huangzurong
 */
@Component
public class TeacherClientFallback extends BaseClientFallback<Teacher,Long> implements TeacherClient {
}
