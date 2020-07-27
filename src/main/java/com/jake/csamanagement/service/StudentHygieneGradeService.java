package com.jake.csamanagement.service;

import com.jake.csamanagement.dao.StudentHygieneGradeMapper;
import com.jake.csamanagement.entity.StudentHygieneGrade;
import com.jake.csamanagement.model.StudentHygieneGradeInfo;
import com.jake.csamanagement.model.StudentRecordForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class StudentHygieneGradeService {
    @Autowired
    StudentHygieneGradeMapper studentHygieneGradeMapper;

    public int addStudentHygieneGrade(List<StudentHygieneGrade> studentHygieneGradeList){

        for (StudentHygieneGrade item :
                studentHygieneGradeList) {
            studentHygieneGradeMapper.addStudentHygieneGrade(item);
        }

        return 1;
    }

    public List<StudentHygieneGradeInfo> getStudentHygieneGradeList(int roomId, Date recordTime){
        return studentHygieneGradeMapper.getStudentHygieneGradeList(roomId,recordTime);
    }

    public int updateStudentHygieneGrade(List<StudentRecordForm> studentRecordFormList)
    {

        for (StudentRecordForm item :
                studentRecordFormList) {
            studentHygieneGradeMapper.updateStudentHygieneGrade(item.getStudentRecordId(),item.getStudentHygieneGrade(),item.getRecordTime());
        }

        return 1;
    }
}
