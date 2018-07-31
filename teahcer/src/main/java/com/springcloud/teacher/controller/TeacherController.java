package com.springcloud.teacher.controller;

import com.springcloud.teacher.client.SchoolClient;
import com.springcloud.teacher.client.StudentClient;
import com.springcloud.teacher.dto.Response;
import com.springcloud.teacher.dto.School;
import com.springcloud.teacher.dto.Student;
import com.springcloud.teacher.po.Teacher;
import com.springcloud.teacher.service.TeacherService;
import com.springcloud.teacher.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController {


    @Autowired
    private StudentClient studentClient;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SchoolClient schoolClient;

    @PostMapping("/create")
    public Object createTeacher(String name, Integer sex, Long schoolId) {
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setSex(sex);
        teacher.setSchoolId(schoolId);
        teacherService.save(teacher);
        return Status.success("请求成功").put("teacher", teacher);
    }

    @GetMapping("get/{teacherId}")
    public Object getTeacher(@PathVariable Long teacherId){
        Optional<Teacher> optional = teacherService.findById(teacherId);
        if(optional.isPresent()) {
            return Status.success("请求成功").put("teacher", optional.get());
        }
        return Status.wrong("id为%d的老师不存在", teacherId);
    }

    @GetMapping("list")
    public Object list(Integer page, Integer size){
        Optional<Integer> pageOpt = Optional.ofNullable(page);
        Optional<Integer> sizeOpt = Optional.ofNullable(size);
        return teacherService.list(pageOpt.orElse(0), sizeOpt.orElse(10));
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

    @GetMapping("getStudent/{studentId}")
    public Object getStudent(@PathVariable Long studentId){
        Response<Student> response = studentClient.findById(studentId);
        if(response.isSucceed()){
            Optional<Student> optional = response.getBean("student");
            if (optional.isPresent()){
                return Status.success("请求成功").put("student", optional.get());
            }
            return Status.wrong("获取id为%d的学生失败");
        }
        return response;
    }

    @GetMapping("getStudentFallback/{studentId}")
    public Object getStudentFallback(@PathVariable Long studentId){
        return studentClient.findByIdFallback(studentId);
    }
}
