package com.jake.csamanagement.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ImportMapper {

    int insertDept(@Param("deptId") int deptId,@Param("deptName") String deptName);
    int insertClass(@Param("classId") int classId,@Param("className") String className,@Param("year") int year,@Param("mdeptId") int mdeptId);
    int insertBuild(@Param("buildId") int buildId,@Param("buildNumber") String buildNumber);
    int insertRoom(@Param("roomId") int roomId,@Param("rbuildId") int rbuildId,@Param("roomNumber") String roomNumber);
    int insertStudent(@Param("studentId") String studentId,@Param("name") String name,@Param("sclassId") int sclassId,@Param("sroomId") int sroomId,@Param("bedNumber") int bedNumber);


}
