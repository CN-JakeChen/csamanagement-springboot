package com.jake.csamanagement.controller;

import com.jake.csamanagement.entity.*;
import com.jake.csamanagement.model.StudentRecordForm;
import com.jake.csamanagement.pojo.Meta;
import com.jake.csamanagement.pojo.Result;
import com.jake.csamanagement.service.StudentHygieneGradeService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studentHygieneGrades")
public class StudentHygieneGradeController {
    @Autowired
    StudentHygieneGradeService studentHygieneGradeService;

    @RequiresRoles(logical= Logical.OR, value = {"1","3"})
    @PostMapping
    public Result addStudentHygieneGrade(@RequestBody List<StudentHygieneGrade> studentHygieneGradeList) {
//        for (StudentHygieneGrade item :
//                studentHygieneGradeList) {
//            System.out.println(item.getStudentNumber());
//            System.out.println(item.getRecord());
//        }
        Meta meta=new Meta();
        Result result = new Result();
        if(studentHygieneGradeService.addStudentHygieneGrade(studentHygieneGradeList)!=0)
        {
            meta.setMsg("添加成功");
            meta.setStatus(200);
            result.setMeta(meta);
            return result;
        }else {
            meta.setMsg("添加失败");
            meta.setStatus(900);
            result.setMeta(meta);
            return result;
        }
    }

    @PutMapping()
    public Result updateStudentHygieneGrade(@RequestBody List<StudentRecordForm> studentRecordFormList){
        Meta meta=new Meta();
        Result result=new Result();
        for (StudentRecordForm item :
                studentRecordFormList) {
            System.out.println(item.getStudentHygieneGrade());
        }
        if(studentHygieneGradeService.updateStudentHygieneGrade(studentRecordFormList)!=0){
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
//    @GetMapping("/{roomId}/{recordDate}")
//    public Result getStudentHygieneGrade(@PathVariable("roomId") int roomId,@PathVariable("recordDate") Date recordDate){
//        Result result=new Result();
//        result.setData(studentHygieneGradeService.getStudentHygieneGradeList(roomId,recordDate));
//        Meta meta=new Meta();
//        meta.setStatus(200);
//        meta.setMsg("成功");
//        result.setMeta(meta);
//        return result;
//    }
}
