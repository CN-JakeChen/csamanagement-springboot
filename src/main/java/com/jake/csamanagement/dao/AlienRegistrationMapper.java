package com.jake.csamanagement.dao;

import com.jake.csamanagement.entity.AlienRegistration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AlienRegistrationMapper {
    int addAlienInfo(AlienRegistration alienRegistration);
    List<AlienRegistration> queryAlienInfo(@Param("queryInfo") String queryInfo);
    List<AlienRegistration> getAlienList(@Param("visitBuild") String visitBuild);
    List<AlienRegistration> getAlienListByList(List<String> buildList);
    int updateAlienInfo(AlienRegistration alienRegistration);
}
