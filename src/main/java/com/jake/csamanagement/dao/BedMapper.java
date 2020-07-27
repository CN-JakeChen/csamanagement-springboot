package com.jake.csamanagement.dao;

import com.jake.csamanagement.entity.Bed;
import com.jake.csamanagement.entity.NewBed;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BedMapper {
    List<Bed> getBedInfo(@Param("roomId") int roomId);
    int addBed(NewBed newBed);
    int searchABed(@Param("roomId") int roomId,@Param("bedNumber") int bedNumber);
    int deleteBed(@Param("studentId") String studentId);
}
