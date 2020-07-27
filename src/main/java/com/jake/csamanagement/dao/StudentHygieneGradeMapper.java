package com.jake.csamanagement.dao;

import com.jake.csamanagement.entity.StudentHygieneGrade;
import com.jake.csamanagement.model.StudentHygieneGradeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface StudentHygieneGradeMapper {
    int addStudentHygieneGrade(StudentHygieneGrade studentHygieneGrade);
    List<StudentHygieneGradeInfo> getStudentHygieneGradeList(@Param("roomId") int roomId, @Param("recordTime") Date recordTime);
    int updateStudentHygieneGrade(@Param("studentRecordId") int studentRecordId,@Param("record") float record,@Param("recordTime") Date recordTime);
}
