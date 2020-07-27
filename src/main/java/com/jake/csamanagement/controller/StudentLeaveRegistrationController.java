package com.jake.csamanagement.controller;

import com.jake.csamanagement.pojo.Meta;
import com.jake.csamanagement.pojo.Page;
import com.jake.csamanagement.pojo.Result;
import com.jake.csamanagement.model.StudentLeaveRegistrationInfo;
import com.jake.csamanagement.entity.StudentLeaveRegistration;
import com.jake.csamanagement.service.StudentLeaveRegistrationService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studentLeaveRegistrations")
public class StudentLeaveRegistrationController {

    @Autowired
    StudentLeaveRegistrationService studentLeaveRegistrationService;

    @RequiresRoles(logical= Logical.OR, value = {"1","3"})
    @GetMapping("/{pageNum}/{pageSize}")
    public Result StudentLeaveRegistration(@RequestHeader("Token") String token,@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize)
    {
        Page page=new Page();

        List<StudentLeaveRegistrationInfo> studentLeaveRegistrationInfoList=studentLeaveRegistrationService.getStudentInfo(token,pageNum,pageSize,page);

        Meta meta=new Meta();
        meta.setMsg("成功");
        meta.setStatus(200);
        Result result=new Result();
        result.setData(page);
        result.setMeta(meta);

        return result;
    }

    @RequiresRoles(logical= Logical.OR, value = {"1","3"})
    @GetMapping("/{status}/{pageNum}/{pageSize}")
    public Result getStudentStatusList(@RequestHeader("Token") String token,@PathVariable("status") int status,@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize)
    {
        Page page=new Page();

        List<StudentLeaveRegistrationInfo> studentLeaveRegistrationInfoList=studentLeaveRegistrationService.getStudentStatusList(status,token,pageNum,pageSize,page);

        Meta meta=new Meta();
        meta.setMsg("成功");
        meta.setStatus(200);
        Result result=new Result();
        result.setData(page);
        result.setMeta(meta);

        return result;
    }


    @PostMapping
    public Result addStudentLeaveRegistration(@RequestBody StudentLeaveRegistration studentLeaveRegistration)
    {
        Result result=new Result();
        Meta meta=new Meta();
        if(studentLeaveRegistrationService.addStudentInfo(studentLeaveRegistration)!=0)
        {
            meta.setMsg("添加学生离校登记信息成功");
            meta.setStatus(200);
            result.setMeta(meta);
        }else {
            meta.setMsg("您已登记了离校信息，请不要重复登记");
            meta.setStatus(900);
            result.setMeta(meta);
        }
        return result;
    }


}
