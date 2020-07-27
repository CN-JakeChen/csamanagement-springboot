package com.jake.csamanagement.dao;

import com.jake.csamanagement.entity.PageTest;
import com.jake.csamanagement.entity.Test;
import com.jake.csamanagement.entity.Test2;
import com.jake.csamanagement.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TestMapper {

    User getUser(@Param("username") String username);
    void tTest(@Param("id") int id);
    void tTestb();
    List<Test> getT1();
    List<Test2> getT2();
    List<PageTest> testPage();
}
