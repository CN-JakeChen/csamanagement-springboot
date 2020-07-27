package com.jake.csamanagement.controller;

import com.jake.csamanagement.pojo.Meta;
import com.jake.csamanagement.entity.NewBed;
import com.jake.csamanagement.pojo.Result;
import com.jake.csamanagement.service.BedService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/beds")
public class BedController {
    @Autowired
    BedService bedService;

    @RequiresRoles(logical= Logical.OR, value = {"1","3"})
    @GetMapping("{roomId}")
    public Result getBedList(@PathVariable("roomId") int roomId)
    {
        Result result=new Result();
        result.setData(bedService.getBedList(roomId));
        Meta meta=new Meta();
        meta.setMsg("获取床位信息成功");
        meta.setStatus(200);
        result.setMeta(meta);
        return result;
    }

    @RequiresRoles(logical= Logical.OR, value = {"1","3"})
    @PostMapping
    public Result addBedInfo(@RequestBody NewBed newBed)
    {
        System.out.println(newBed.getStudentNumber());
        System.out.println(newBed.getRoomId());
        System.out.println(newBed.getBedNumber());
        Result result=new Result();
        Meta meta=new Meta();
        if(bedService.addBed(newBed)!=0)
        {
            meta.setMsg("添加床位成功");
            meta.setStatus(200);
            result.setMeta(meta);
            return result;
        }else {
            meta.setMsg("该床位已经有人");
            meta.setStatus(900);
            result.setMeta(meta);
            return result;
        }

    }

    @RequiresRoles(logical= Logical.OR, value = {"1","3"})
    @DeleteMapping("{studentId}")
    public Result deleteBed(@PathVariable("studentId") String studentId)
    {
        Meta meta=new Meta();

        Result result=new Result();
        if(bedService.deleteBed(studentId)!=0)
        {
            meta.setMsg("删除成功");
            meta.setStatus(200);
            result.setMeta(meta);
            return result;
        }else {
            meta.setMsg("删除失败");
            meta.setStatus(900);
            result.setMeta(meta);
            return result;
        }

    }
}
