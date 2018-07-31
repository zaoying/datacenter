package com.springcloud.school.dao;

import com.springcloud.school.po.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author huangzurong
 */
@Repository
public interface SchoolDAO extends JpaRepository<School, Long> {
}
