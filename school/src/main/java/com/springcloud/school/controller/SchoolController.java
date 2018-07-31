package com.springcloud.school.controller;

import com.springcloud.school.client.StudentClient;
import com.springcloud.school.client.TeacherClient;
import com.springcloud.school.dto.Response;
import com.springcloud.school.dto.Student;
import com.springcloud.school.dto.Teacher;
import com.springcloud.school.po.School;
import com.springcloud.school.service.SchoolService;
import com.springcloud.school.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @Autowired
    private StudentClient studentClient;

    @Autowired
    private TeacherClient teacherClient;

    @PostMapping("create")
    public Object createSchool(String name, String address){
        School school = new School();
        school.setName(name);
        school.setAddress(address);
        schoolService.save(school);
        return Status.success("请求成功").put("school", school);
    }

    @GetMapping("get/{schoolId}")
    public Object getSchool(@PathVariable Long schoolId){
        Optional<School> optional = schoolService.findById(schoolId);
        if(optional.isPresent()) {
            return Status.success("请求成功").put("school", optional.get());
        }
        return Status.wrong("id为%d的学校不存在", schoolId);
    }

    @GetMapping("list")
    public Object list(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size){
        Optional<Integer> pageOpt = Optional.ofNullable(page);
        Optional<Integer> sizeOpt = Optional.ofNullable(size);
        return schoolService.list(pageOpt.orElse(0), sizeOpt.orElse(10));
    }

    @GetMapping("getStudent/{studentId}")
    public Object getStudent(@PathVariable Long studentId){
        Response<Student> response = studentClient.findById(studentId);
        if(response.isSucceed()){
            Optional<Student> optional = response.getBean("student");
            if (optional.isPresent()){
                return Status.success("请求成功").put("student", optional.get());
            }
            return Status.wrong("获取id为%d的教师失败");
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

    @GetMapping("getTeacherAndStudent/{schoolId}")
    public Object getTeacherAndStudent(@PathVariable Long schoolId){
        return new Teacher();
    }


}
