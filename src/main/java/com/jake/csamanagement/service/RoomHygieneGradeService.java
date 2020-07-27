package com.jake.csamanagement.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jake.csamanagement.dao.RoomHygieneGradeMapper;
import com.jake.csamanagement.dao.StudentHygieneGradeMapper;
import com.jake.csamanagement.dao.UserMapper;
import com.jake.csamanagement.pojo.Page;
import com.jake.csamanagement.entity.RoomHygieneGrade;
import com.jake.csamanagement.model.RoomHygieneGradeInfo;
import com.jake.csamanagement.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RoomHygieneGradeService {
    @Autowired
    RoomHygieneGradeMapper roomHygieneGradeMapper;

    @Autowired
    StudentHygieneGradeMapper studentHygieneGradeMapper;

    @Autowired
    UserMapper userMapper;
    public int addRoomHygieneGrade(RoomHygieneGrade roomHygieneGrade){
        return roomHygieneGradeMapper.addRoomHygieneGrade(roomHygieneGrade);
    }

    public List<RoomHygieneGradeInfo> getRoomHygieneGradeList(){
        List<RoomHygieneGradeInfo> list=roomHygieneGradeMapper.getRoomHygieneGradeList();
        for (RoomHygieneGradeInfo item :
               list ) {
            item.setStudentHygieneGradeInfoList(studentHygieneGradeMapper.getStudentHygieneGradeList(item.getRoomId(),item.getRecordTime()));
        }
        return list;
    }

    public List<RoomHygieneGradeInfo> getRoomHygieneGradeList(String token, int pageNum, int pageSize, Page page){
        String username = JWTUtil.getUsername(token);
        List<RoomHygieneGradeInfo> list=new ArrayList<>();
        int usize=userMapper.getUserManFieldByUsername(username).size();
        List<String> uList=userMapper.getUserManFieldByUsername(username);
        if(usize==0)
        {
            page.setPageNum(pageNum);
            page.setPageSize(pageSize);
            PageHelper.startPage(pageNum,pageSize);
            list=roomHygieneGradeMapper.getRoomHygieneGradeList();
        }
        else {
            page.setPageNum(pageNum);
            page.setPageSize(pageSize);
            PageHelper.startPage(pageNum,pageSize);
            list=roomHygieneGradeMapper.getRoomHygieneGradeListByBuilds(uList);
        }

        for (RoomHygieneGradeInfo item :
                list ) {
            item.setStudentHygieneGradeInfoList(studentHygieneGradeMapper.getStudentHygieneGradeList(item.getRoomId(),item.getRecordTime()));
        }
        PageInfo<RoomHygieneGradeInfo> pageInfo=new PageInfo<>(list);
        page.setPageData(list);
        page.setTotal(Integer.parseInt(pageInfo.getTotal()+""));
        return list;
    }

    public int updateRoomHygieneGrade(int roomRecordId, float record, Date recordTime){
        return roomHygieneGradeMapper.updateRoomHygieneGrade(roomRecordId,record,recordTime);
    }
}
