package com.jake.csamanagement.controller;

import com.jake.csamanagement.pojo.Meta;
import com.jake.csamanagement.pojo.Result;
import com.jake.csamanagement.service.StudentService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequiresRoles(logical= Logical.OR, value = {"1","3"})
    @GetMapping("/{studentNumber}")
    public Result getStudentInfo(@PathVariable("studentNumber") String studentNumber){
        Result result=new Result();
        result.setData(studentService.getStudentInfo(studentNumber));
        Meta meta=new Meta();
        meta.setMsg("获取学生信息成功");
        meta.setStatus(200);
        result.setMeta(meta);
        return result;
    }
}
