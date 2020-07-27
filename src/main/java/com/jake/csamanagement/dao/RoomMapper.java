package com.jake.csamanagement.dao;

import com.jake.csamanagement.model.RoomInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RoomMapper {
    List<RoomInfo> getRoomInfo(@Param("buildNumber") String buildNumber,@Param("roomNumber") String roomNumber);
    List<RoomInfo> getRoomInfoByList(List<String> buildList);
    Integer getNumberOfPeople(@Param("numberOfPeople") int numberOfPeople);

}
