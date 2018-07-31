package com.springcloud.school.po;

import javax.persistence.*;

/**
 * @author huangzurong
 */
@Entity
@Table(name = "t_school")
public class School {

    private Long id;

    private String name;

    private String address;

    @Id()
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
