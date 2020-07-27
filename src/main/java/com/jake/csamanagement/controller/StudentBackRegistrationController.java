package com.jake.csamanagement.controller;

import com.jake.csamanagement.pojo.Meta;
import com.jake.csamanagement.pojo.Page;
import com.jake.csamanagement.pojo.Result;
import com.jake.csamanagement.model.StudentLeaveRegistrationInfo;
import com.jake.csamanagement.entity.StudentBackRegistration;
import com.jake.csamanagement.service.StudentBackRegistrationService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studentBackRegistration")
public class StudentBackRegistrationController {
    @Autowired
    StudentBackRegistrationService studentBackRegistrationService;

    @PostMapping
    public Result addStudentBackRegistration(@RequestBody StudentBackRegistration studentBackRegistration)
    {
        Meta meta=new Meta();
        Result result=new Result();
        if(studentBackRegistrationService.addStudentBackRegistration(studentBackRegistration)!=0)
        {
            meta.setMsg("添加返校登记记录成功");
            meta.setStatus(200);
            result.setMeta(meta);
        }
        else {
            meta.setMsg("您已登记了返校信息，请不要重复登记");
            meta.setStatus(900);
            result.setMeta(meta);
        }
        return result;
    }

    @RequiresRoles(logical= Logical.OR, value = {"1","3"})
    @GetMapping("/{pageNum}/{pageSize}")
    public Result getStudentBackRegistrationList(@RequestHeader("Token") String token,@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize){

        Page page=new Page();

        List<StudentLeaveRegistrationInfo> studentBackRegistrationList=studentBackRegistrationService.getStudentBackRegistrationList(token,pageNum,pageSize,page);

        Meta meta=new Meta();
        meta.setMsg("成功");
        meta.setStatus(200);
        Result result=new Result();
        result.setData(page);
        result.setMeta(meta);
        return result;
    }
}
