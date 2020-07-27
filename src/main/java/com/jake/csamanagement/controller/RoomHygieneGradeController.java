package com.jake.csamanagement.controller;

import com.jake.csamanagement.entity.*;
import com.jake.csamanagement.model.RoomHygieneGradeInfo;
import com.jake.csamanagement.pojo.Meta;
import com.jake.csamanagement.pojo.Page;
import com.jake.csamanagement.pojo.Result;
import com.jake.csamanagement.service.RoomHygieneGradeService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/roomHygieneGrades")
public class RoomHygieneGradeController {
    @Autowired
    RoomHygieneGradeService roomHygieneGradeService;

    @RequiresRoles(logical= Logical.OR, value = {"1","3"})
    @PostMapping
    public Result addRoomHygieneGrade(@RequestBody RoomHygieneGrade roomHygieneGrade)
    {
        System.out.println(roomHygieneGrade.getRoomId());
        System.out.println(roomHygieneGrade.getRoomHygieneGrade());
        Result result=new Result();
        Meta meta=new Meta();
        if (roomHygieneGradeService.addRoomHygieneGrade(roomHygieneGrade)!=0)
        {
            meta.setMsg("添加成功");
            meta.setStatus(200);
            result.setMeta(meta);
            return result;
        }
        else {
            meta.setMsg("添加失败");
            meta.setStatus(900);
            result.setMeta(meta);
            return result;
        }

    }

    @GetMapping("/{pageNum}/{pageSize}")
    public Result getRoomHygieneInfo(@RequestHeader("Token") String token,@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize)
    {
        Page page=new Page();
        List<RoomHygieneGradeInfo> roomHygieneGradeList=roomHygieneGradeService.getRoomHygieneGradeList(token,pageNum,pageSize,page);
        Meta meta=new Meta();
        meta.setMsg("成功");
        meta.setStatus(200);
        Result result=new Result();
        result.setData(page);
        result.setMeta(meta);
        return result;
    }

    @PutMapping("/{roomRecordId}/{record}/{recordTime}")
    public Result updateRoomHygieneGrade(@PathVariable("roomRecordId") int roomRecordId, @PathVariable("record") float record, @PathVariable("recordTime")Date recordTime){
        Meta meta=new Meta();
        Result result=new Result();
        System.out.println(roomRecordId+","+record);
        if (roomHygieneGradeService.updateRoomHygieneGrade(roomRecordId,record,recordTime)!=0)
        {
            meta.setStatus(200);
            meta.setMsg("更新成功");
            result.setMeta(meta);
        }else {
            meta.setStatus(1000);
            meta.setMsg("更新失败");
            result.setMeta(meta);
        }
        return result;
    }
}
