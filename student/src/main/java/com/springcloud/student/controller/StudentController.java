package com.springcloud.student.controller;

import com.springcloud.student.client.SchoolClient;
import com.springcloud.student.client.TeacherClient;
import com.springcloud.student.dto.Response;
import com.springcloud.student.dto.School;
import com.springcloud.student.dto.Teacher;
import com.springcloud.student.po.Student;
import com.springcloud.student.service.StudentService;
import com.springcloud.student.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author huangzurong
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherClient teacherClient;

    @Autowired
    private SchoolClient schoolClient;

    @PostMapping("/create")
    public Object createStudent(String name, String studentNo, Integer sex) {
        Student student = new Student();
        student.setName(name);
        student.setStudentNo(studentNo);
        student.setSex(sex);
        studentService.save(student);
        return Status.success("请求成功").put("student", student);
    }

    @GetMapping("get/{studentId}")
    public Object getStudent(@PathVariable Long studentId){
        Optional<Student> optional = studentService.findById(studentId);
        if(optional.isPresent()) {
            return Status.success("请求成功").put("student", optional.get());
        }
        return Status.wrong("id为%d的学生不存在", studentId);
    }

    @GetMapping("list")
    public Object list(Integer page, Integer size){
        Optional<Integer> pageOpt = Optional.ofNullable(page);
        Optional<Integer> sizeOpt = Optional.ofNullable(size);
        return studentService.list(pageOpt.orElse(0), sizeOpt.orElse(10));
    }

    @GetMapping("getSchool/{schoolId}")
    public Object getSchool(@PathVariable Long schoolId){
        Response<School> response = schoolClient.findById(schoolId);
        if(response.isSucceed()){
            Optional<School> optional = response.getBean("school");
            if (optional.isPresent()){
                return Status.success("请求成功").put("school", optional.get());
            }
            return Status.wrong("获取id为%d的学校失败");
        }
        return response;
    }

    @GetMapping("getTeacher/{teacherId}")
    public Object getTeacher(@PathVariable Long teacherId){
        Response<Teacher> response = teacherClient.findById(teacherId);
        if(response.isSucceed()){
            Optional<Teacher> optional = response.getBean("teacher");
            if (optional.isPresent()){
                return Status.success("请求成功").put("teacher", optional.get());
            }
            return Status.wrong("获取id为%d的教师失败");
        }
        return response;
    }

    @GetMapping("getSchoolAndTeacher/{schoolId}")
    public Object getSchoolAndTeacher(@PathVariable Long schoolId){
        return new Teacher();
    }
}
