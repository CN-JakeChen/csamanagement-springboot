package com.jake.csamanagement.dao;

import com.jake.csamanagement.model.StudentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface StudentMapper {
    StudentInfo getStudentById(@Param("studentId") String studentId);
}
