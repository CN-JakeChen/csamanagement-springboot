package com.jake.csamanagement.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jake.csamanagement.pojo.Meta;
import com.jake.csamanagement.pojo.Page;
import com.jake.csamanagement.pojo.Result;
import com.jake.csamanagement.model.RoomInfo;
import com.jake.csamanagement.service.RoomService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    RoomService roomService;

    @RequiresRoles(logical= Logical.OR, value = {"1","3"})
    @GetMapping("/{buildNumber}/{roomNumber}/{pageNum}/{pageSize}")
    public Result getRoomsList(@PathVariable("buildNumber") String buildNumber,@PathVariable("roomNumber") String roomNumber,@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize)
    {
        System.out.println(buildNumber);
        System.out.println(roomNumber);
        Page page=new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);

        PageHelper.startPage(pageNum,pageSize);
        List<RoomInfo> roomInfoList=roomService.getRoomList(buildNumber,roomNumber);
        PageInfo<RoomInfo> pageInfo=new PageInfo<>(roomInfoList);
        page.setPageData(roomInfoList);
        page.setTotal(Integer.parseInt(pageInfo.getTotal()+""));

        Meta meta=new Meta();
        meta.setMsg("获取寝室信息成功");
        meta.setStatus(200);
        Result result=new Result();
        result.setData(page);
        result.setMeta(meta);
        return result;
    }


    @GetMapping("/{pageNum}/{pageSize}")
    public Result getRoomsListByRoomAdmin(@RequestHeader("Token") String token, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize)
    {

        Page page=new Page();
        List<RoomInfo> roomInfoList=roomService.getRoomList(token,pageNum,pageSize,page);
        Meta meta=new Meta();
        meta.setMsg("获取寝室信息成功");
        meta.setStatus(200);
        Result result=new Result();
        result.setData(page);
        result.setMeta(meta);
        return result;
    }


}
