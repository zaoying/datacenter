package com.springcloud.teacher.fallback;


import com.springcloud.teacher.client.SchoolClient;
import com.springcloud.teacher.dto.School;
import org.springframework.stereotype.Component;

/**
 * @author huangzurong
 */
@Component
public class SchoolClientFallback extends BaseClientFallback<School,Long> implements SchoolClient {
}
