package com.jake.csamanagement.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jake.csamanagement.dao.StudentBackRegistrationMapper;
import com.jake.csamanagement.dao.UserMapper;
import com.jake.csamanagement.pojo.Page;
import com.jake.csamanagement.model.StudentLeaveRegistrationInfo;
import com.jake.csamanagement.entity.StudentBackRegistration;
import com.jake.csamanagement.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentBackRegistrationService {

    @Autowired
    StudentBackRegistrationMapper studentBackRegistrationMapper;

    @Autowired
    UserMapper userMapper;
    public int addStudentBackRegistration(StudentBackRegistration studentBackRegistration) {
        if(studentBackRegistrationMapper.getStudentStatusByStudentNumber(studentBackRegistration.getStudentNumber())!=0)
        {
            return 0;
        }

        studentBackRegistrationMapper.addStudentBackRegistration(studentBackRegistration);
        studentBackRegistrationMapper.updateStudentBackRegistration(studentBackRegistration.getStudentNumber());

        return 1;
    }

    public List<StudentLeaveRegistrationInfo> getStudentBackRegistrationList(){
        return studentBackRegistrationMapper.getStudentBackRegistrationList();
    }

    public List<StudentLeaveRegistrationInfo> getStudentBackRegistrationList(String token, int pageNum, int pageSize, Page page){
        String username = JWTUtil.getUsername(token);
        int usize=userMapper.getUserManFieldByUsername(username).size();
        List<String> uList=userMapper.getUserManFieldByUsername(username);
        List<StudentLeaveRegistrationInfo> studentBackRegistrationList= new ArrayList<>();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        PageHelper.startPage(pageNum,pageSize);
        if (usize==0) {
            System.out.println("到达管理员");
            page.setPageNum(pageNum);
            page.setPageSize(pageSize);
            PageHelper.startPage(pageNum,pageSize);
            studentBackRegistrationList=studentBackRegistrationMapper.getStudentBackRegistrationList();

        } else {
            System.out.println("到达公寓");
            page.setPageNum(pageNum);
            page.setPageSize(pageSize);
            PageHelper.startPage(pageNum,pageSize);
            studentBackRegistrationList=studentBackRegistrationMapper.getStudentBackRegistrationListByBuild(uList);
        }
        PageInfo<StudentLeaveRegistrationInfo> pageInfo=new PageInfo<>(studentBackRegistrationList);
        page.setTotal(Integer.parseInt(pageInfo.getTotal()+""));
        page.setPageData(studentBackRegistrationList);
        return studentBackRegistrationList;
    }
}
