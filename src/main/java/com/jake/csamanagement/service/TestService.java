package com.jake.csamanagement.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jake.csamanagement.dao.TestMapper;
import com.jake.csamanagement.entity.PageTest;
import com.jake.csamanagement.entity.Test;
import com.jake.csamanagement.entity.Test2;
import com.jake.csamanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    TestMapper testMapper;

    public User getUser(String username)
    {
        User user=testMapper.getUser(username);
        User userInfo=new User();
        userInfo.setUsername(user.getUsername());
        userInfo.setId(user.getId());
        return userInfo;
    }

    public void t1()
    {

        for (Test t :testMapper.getT1()) {
            System.out.println(t.getBedNum()+","+t.getStudentId()+","+t.getStudentName()+","+t.getClassName());
        }
    }
    public void t2(){
        for (Test2 t :testMapper.getT2()) {
            System.out.println(t.getRecord()+","+t.getRecordDate());
        }
    }

    public void pageTest(){
        PageHelper.startPage(1,2);
        List<PageTest> pageTestList=testMapper.testPage();
        PageInfo<PageTest> pageInfo=new PageInfo<>(pageTestList);
        for (PageTest pageTest:pageTestList)
        {
            System.out.println(pageTest.getId()+" "+pageTest.getName());
        }
        System.out.println("总记录"+pageInfo.getTotal());
        System.out.println("总页数"+pageInfo.getPages());
    }
}
