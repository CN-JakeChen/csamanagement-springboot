package com.jake.csamanagement.service;

import com.jake.csamanagement.dao.StudentMapper;
import com.jake.csamanagement.model.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    public StudentInfo getStudentInfo(String studentId)
    {
        return studentMapper.getStudentById(studentId);
    }
}
