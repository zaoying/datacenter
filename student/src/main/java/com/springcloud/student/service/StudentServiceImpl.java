package com.springcloud.student.service;

import com.springcloud.student.po.Student;
import org.springframework.stereotype.Service;

/**
 * @author huangzurong
 */

@Service
public class StudentServiceImpl extends BaseServiceImpl<Student,Long> implements StudentService{
}
