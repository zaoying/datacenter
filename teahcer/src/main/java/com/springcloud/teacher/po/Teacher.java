package com.springcloud.teacher.po;

import javax.persistence.*;

/**
 * @author huangzurong
 */
@Entity
@Table(name = "t_teacher")
public class Teacher {

    private Long id;

    private String name;

    private Integer sex;

    private Long schoolId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Column(name = "school_id")
    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }
}
