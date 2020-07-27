package com.jake.csamanagement.dao;

import com.jake.csamanagement.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DeptMapper {
    List<Dept> getDepts();
    String getDepNametByDeptId(@Param("deptId") int deptId);
}
