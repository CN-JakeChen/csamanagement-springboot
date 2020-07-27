package com.jake.csamanagement.dao;

import com.jake.csamanagement.entity.Build;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BuildMapper {
    List<Build> getBuilds();
}
