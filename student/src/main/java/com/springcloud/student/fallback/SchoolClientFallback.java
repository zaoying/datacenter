package com.springcloud.student.fallback;

import com.springcloud.student.client.SchoolClient;
import com.springcloud.student.dto.School;
import org.springframework.stereotype.Component;

@Component
public class SchoolClientFallback extends BaseClientFallback<School,Long> implements SchoolClient {
}
