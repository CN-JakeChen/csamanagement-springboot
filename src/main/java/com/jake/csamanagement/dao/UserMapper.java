package com.jake.csamanagement.dao;

import com.jake.csamanagement.model.AddForm;
import com.jake.csamanagement.model.EditForm;
import com.jake.csamanagement.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    int insertUser(AddForm addForm);

    int updateUser(EditForm editForm);

    int deleteUser(@Param("userId") int userId);

    List<User> getUsers(@Param("userName") String userName);

    List<String> getUserManField(@Param("userId") int userId);

    List<String> getUserManFieldByUsername(@Param("username") String username);

    int insertUserMan(@Param("userId") int userId, @Param("buildId") int buildId);
    String getPasswordByUsername(@Param("username") String username);
    Integer getRoleByUsername(@Param("username") String username);
}
