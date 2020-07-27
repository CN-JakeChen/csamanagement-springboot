package com.jake.csamanagement.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jake.csamanagement.dao.RoomMapper;
import com.jake.csamanagement.dao.UserMapper;
import com.jake.csamanagement.pojo.Page;
import com.jake.csamanagement.model.RoomInfo;
import com.jake.csamanagement.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    RoomMapper roomMapper;
    @Autowired
    UserMapper userMapper;

    public List<RoomInfo> getRoomList(String buildNumber, String roomNumber) {
        List<RoomInfo> roomInfoList = roomMapper.getRoomInfo(buildNumber, roomNumber);
        for (RoomInfo roomInfo : roomInfoList) {
            if (roomMapper.getNumberOfPeople(roomInfo.getRoomId()) == null) {
                roomInfo.setNumberOfPeople(0);
            } else {
                roomInfo.setNumberOfPeople(roomMapper.getNumberOfPeople(roomInfo.getRoomId()));
            }
        }
        return roomInfoList;
    }

    public List<RoomInfo> getRoomList(String token,int pageNum,int pageSize,Page page) {
        String username = JWTUtil.getUsername(token);
        System.out.println(username);
        List<RoomInfo> roomInfoList = new ArrayList<>();
        int usize=userMapper.getUserManFieldByUsername(username).size();
        List<String> uList=userMapper.getUserManFieldByUsername(username);

        if (usize==0) {
            page.setPageNum(pageNum);
            page.setPageSize(pageSize);
            PageHelper.startPage(pageNum,pageSize);
            roomInfoList = roomMapper.getRoomInfo(" ", " ");

        } else {
            page.setPageNum(pageNum);
            page.setPageSize(pageSize);
            PageHelper.startPage(pageNum,pageSize);
            roomInfoList=roomMapper.getRoomInfoByList(uList);

        }



        for (RoomInfo roomInfo : roomInfoList) {
            if (roomMapper.getNumberOfPeople(roomInfo.getRoomId()) == null) {
                roomInfo.setNumberOfPeople(0);
            } else {
                roomInfo.setNumberOfPeople(roomMapper.getNumberOfPeople(roomInfo.getRoomId()));
            }
        }
        PageInfo<RoomInfo> pageInfo=new PageInfo<>(roomInfoList);
        page.setPageData(roomInfoList);
        page.setTotal(Integer.parseInt(pageInfo.getTotal()+""));
        return roomInfoList;
    }


}
