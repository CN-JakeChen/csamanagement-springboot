package com.jake.csamanagement.controller;

import com.jake.csamanagement.pojo.Meta;
import com.jake.csamanagement.pojo.Result;
import com.jake.csamanagement.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/depts")
public class DeptController {

    @Autowired
    DeptService deptService;
    @GetMapping
    public Result getDepts(){
        Meta meta=new Meta();
        meta.setMsg("获取院系列表成功");
        meta.setStatus(200);
        Result result=new Result();
        result.setData(deptService.getDepts());
        result.setMeta(meta);
        return result;
    }
}
