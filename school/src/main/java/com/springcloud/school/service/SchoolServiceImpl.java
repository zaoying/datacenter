package com.springcloud.school.service;

import com.springcloud.school.dao.SchoolDAO;
import com.springcloud.school.po.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author huangzurong
 */
@Service
public class SchoolServiceImpl extends BaseServiceImpl<School,Long> implements SchoolService{
}
