package com.jake.csamanagement.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jake.csamanagement.dao.AlienRegistrationMapper;
import com.jake.csamanagement.dao.UserMapper;
import com.jake.csamanagement.pojo.Page;
import com.jake.csamanagement.entity.AlienRegistration;
import com.jake.csamanagement.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AlienRegistrationService {
    @Autowired
    AlienRegistrationMapper alienRegistrationMapper;

    @Autowired
    UserMapper userMapper;


    public int addAlienInfo(AlienRegistration alienRegistration) {
        return alienRegistrationMapper.addAlienInfo(alienRegistration);
    }

    public List<AlienRegistration> getAlienList(String token, int pageNum, int pageSize, Page page) {
//        return alienRegistrationMapper.getAlienList();
        String username = JWTUtil.getUsername(token);
        System.out.println(username);
        List<AlienRegistration> alienRegistrationList = new ArrayList<>();
        int usize=userMapper.getUserManFieldByUsername(username).size();
        List<String> uList=userMapper.getUserManFieldByUsername(username);

        if (usize==0) {
            page.setPageNum(pageNum);
            page.setPageSize(pageSize);
            PageHelper.startPage(pageNum,pageSize);
            alienRegistrationList = alienRegistrationMapper.getAlienList(" ");

        } else {
            page.setPageNum(pageNum);
            page.setPageSize(pageSize);
            PageHelper.startPage(pageNum,pageSize);
            alienRegistrationList=alienRegistrationMapper.getAlienListByList(uList);

        }



        PageInfo<AlienRegistration> pageInfo=new PageInfo<>(alienRegistrationList);
        page.setPageData(alienRegistrationList);
        page.setTotal(Integer.parseInt(pageInfo.getTotal()+""));
        return alienRegistrationList;
    }

    public List<AlienRegistration> queryAlienInfo(String queryInfo)
    {
        return alienRegistrationMapper.queryAlienInfo(queryInfo);
    }

    public int updateAlienInfo(AlienRegistration alienRegistration){
        return alienRegistrationMapper.updateAlienInfo(alienRegistration);
    }
}
