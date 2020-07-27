package com.jake.csamanagement.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface StatisticsMapper {
    Integer getRoomRecordStatistics(@Param("number") String number,@Param("upperBound") Integer upperBound,@Param("lowerBound") Integer lowerBound);
    Integer getAlienStatistics(@Param("dayOfWeek") int dayOfWeek);
}
