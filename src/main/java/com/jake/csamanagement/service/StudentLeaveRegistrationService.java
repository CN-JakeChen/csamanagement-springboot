package com.jake.csamanagement.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jake.csamanagement.dao.StudentLeaveRegistrationMapper;
import com.jake.csamanagement.dao.UserMapper;
import com.jake.csamanagement.pojo.Page;
import com.jake.csamanagement.model.StudentLeaveRegistrationInfo;
import com.jake.csamanagement.entity.StudentLeaveRegistration;
import com.jake.csamanagement.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentLeaveRegistrationService {
    @Autowired
    StudentLeaveRegistrationMapper studentLeaveRegistrationMapper;

    @Autowired
    UserMapper userMapper;
    public int addStudentInfo(StudentLeaveRegistration studentLeaveRegistration)
    {
        if(studentLeaveRegistrationMapper.getStudentStatusByStudentNumber(studentLeaveRegistration.getStudentNumber())!=0)
        {
            return 0;
        }
        studentLeaveRegistrationMapper.addStudentInfo(studentLeaveRegistration);
        studentLeaveRegistrationMapper.updateStudentStatus(studentLeaveRegistration.getStudentNumber(),1);
        return 1;
    }

    public List<StudentLeaveRegistrationInfo> getStudentInfo(){
        return studentLeaveRegistrationMapper.getStudentInfo();
    }

    public List<StudentLeaveRegistrationInfo> getStudentInfo(String token, int pageNum, int pageSize, Page page){
        String username = JWTUtil.getUsername(token);
        System.out.println(username);
        List<StudentLeaveRegistrationInfo> studentLeaveRegistrationInfoList = new ArrayList<>();
        int usize=userMapper.getUserManFieldByUsername(username).size();
        List<String> uList=userMapper.getUserManFieldByUsername(username);

        if (usize==0) {
            page.setPageNum(pageNum);
            page.setPageSize(pageSize);
            PageHelper.startPage(pageNum,pageSize);
            studentLeaveRegistrationInfoList = studentLeaveRegistrationMapper.getStudentInfo();

        } else {
            page.setPageNum(pageNum);
            page.setPageSize(pageSize);
            PageHelper.startPage(pageNum,pageSize);
            studentLeaveRegistrationInfoList=studentLeaveRegistrationMapper.getStudentInfoByBuilds(uList);

        }
        PageInfo<StudentLeaveRegistrationInfo> pageInfo=new PageInfo<>(studentLeaveRegistrationInfoList);
        page.setPageData(studentLeaveRegistrationInfoList);
        page.setTotal(Integer.parseInt(pageInfo.getTotal()+""));

        return studentLeaveRegistrationInfoList;
    }

    public List<StudentLeaveRegistrationInfo> getStudentStatusList(int status)
    {
        return studentLeaveRegistrationMapper.getStudentStatusList(status);
    }

    public List<StudentLeaveRegistrationInfo> getStudentStatusList(int status,String token, int pageNum, int pageSize, Page page)
    {
        String username = JWTUtil.getUsername(token);
        System.out.println(username);
        List<StudentLeaveRegistrationInfo> studentLeaveRegistrationInfoList = new ArrayList<>();
        int usize=userMapper.getUserManFieldByUsername(username).size();
        List<String> uList=userMapper.getUserManFieldByUsername(username);

        if (usize==0) {
            page.setPageNum(pageNum);
            page.setPageSize(pageSize);
            PageHelper.startPage(pageNum,pageSize);
            studentLeaveRegistrationInfoList = studentLeaveRegistrationMapper.getStudentStatusList(status);

        } else {
            page.setPageNum(pageNum);
            page.setPageSize(pageSize);
            PageHelper.startPage(pageNum,pageSize);
            studentLeaveRegistrationInfoList=studentLeaveRegistrationMapper.getStudentStatusListByBuilds(status,uList);

        }
        PageInfo<StudentLeaveRegistrationInfo> pageInfo=new PageInfo<>(studentLeaveRegistrationInfoList);
        page.setPageData(studentLeaveRegistrationInfoList);
        page.setTotal(Integer.parseInt(pageInfo.getTotal()+""));
        return studentLeaveRegistrationInfoList;
    }

}
