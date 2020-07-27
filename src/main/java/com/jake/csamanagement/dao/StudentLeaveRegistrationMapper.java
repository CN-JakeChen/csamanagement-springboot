package com.jake.csamanagement.dao;

import com.jake.csamanagement.model.StudentLeaveRegistrationInfo;
import com.jake.csamanagement.entity.StudentLeaveRegistration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentLeaveRegistrationMapper {
    int addStudentInfo(StudentLeaveRegistration studentLeaveRegistration);
    int updateStudentStatus(@Param("studentNumber") String studentNumber,@Param("status") int status);
    List<StudentLeaveRegistrationInfo> getStudentInfo();
    List<StudentLeaveRegistrationInfo> getStudentInfoByBuilds(List<String> buildList);
    List<StudentLeaveRegistrationInfo> getStudentStatusList(@Param("status") int status);
    List<StudentLeaveRegistrationInfo> getStudentStatusListByBuilds(@Param("status") int status,List<String> buildList);
    Integer getStudentStatusByStudentNumber(@Param("studentNumber") String studentNumber);

}
