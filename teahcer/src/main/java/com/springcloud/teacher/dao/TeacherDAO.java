package com.springcloud.teacher.dao;

import com.springcloud.teacher.po.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDAO extends JpaRepository<Teacher,Long> {
}
