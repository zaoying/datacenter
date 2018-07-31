package com.springcloud.school.fallback;

import com.springcloud.school.client.StudentClient;
import com.springcloud.school.dto.Student;
import org.springframework.stereotype.Component;

/**
 * @author huangzurong
 */
@Component
public class StudentClientFallback extends BaseClientFallback<Student,Long> implements StudentClient {
}
