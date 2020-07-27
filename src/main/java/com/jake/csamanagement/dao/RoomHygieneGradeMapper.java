package com.jake.csamanagement.dao;

import com.jake.csamanagement.entity.RoomHygieneGrade;
import com.jake.csamanagement.model.RoomHygieneGradeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface RoomHygieneGradeMapper {
    int addRoomHygieneGrade(RoomHygieneGrade roomHygieneGrade);
    List<RoomHygieneGradeInfo> getRoomHygieneGradeList();
    List<RoomHygieneGradeInfo> getRoomHygieneGradeListByBuilds(List<String> build);
    int updateRoomHygieneGrade(@Param("roomRecordId") int roomRecodrId, @Param("record") float record, @Param("recordTime")Date recordTime);
}
