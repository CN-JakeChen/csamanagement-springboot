package com.jake.csamanagement.dao;

import com.jake.csamanagement.model.StudentLeaveRegistrationInfo;
import com.jake.csamanagement.entity.StudentBackRegistration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentBackRegistrationMapper {
    int addStudentBackRegistration(StudentBackRegistration studentBackRegistration);
    int updateStudentBackRegistration(@Param("studentNumber") String studentNumber);
    List<StudentLeaveRegistrationInfo> getStudentBackRegistrationList();
    List<StudentLeaveRegistrationInfo> getStudentBackRegistrationListByBuild(List<String> buildList);
    Integer getStudentStatusByStudentNumber(@Param("studentNumber") String studentNumber);
}
