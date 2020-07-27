package com.jake.csamanagement.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jake.csamanagement.pojo.Meta;
import com.jake.csamanagement.pojo.Page;
import com.jake.csamanagement.pojo.Result;
import com.jake.csamanagement.entity.AlienRegistration;
import com.jake.csamanagement.service.AlienRegistrationService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alienRegistrations")
public class AlienRegistrationController {
    @Autowired
    AlienRegistrationService alienRegistrationService;


    @PostMapping
    public Result addAlienInfo(@RequestBody AlienRegistration alienRegistration)
    {
        Meta meta=new Meta();
        Result result=new Result();
        if(alienRegistrationService.addAlienInfo(alienRegistration)!=0)
        {
            meta.setMsg("外来人员信息登记成功");
            meta.setStatus(200);
            result.setMeta(meta);
            return result;
        }
        else {
            meta.setMsg("外来人员信息登记失败");
            meta.setStatus(900);
            result.setMeta(meta);
            return result;
        }
    }

    @RequiresRoles(logical= Logical.OR, value = {"1","3"})
    @GetMapping("/{pageNum}/{pageSize}")
    public Result getAlienList(@RequestHeader("Token") String token,@PathVariable int pageNum,@PathVariable int pageSize){
        Meta meta=new Meta();
        Result result=new Result();
        Page page=new Page();
//        page.setPageNum(pageNum);
//        page.setPageSize(pageSize);
//        PageHelper.startPage(pageNum,pageSize);
        List<AlienRegistration> alienRegistrationList= alienRegistrationService.getAlienList(token,pageNum,pageSize,page);
//        PageInfo<AlienRegistration> pageInfo=new PageInfo<>(alienRegistrationList);
//        page.setTotal(Integer.parseInt(pageInfo.getTotal()+""));
//        page.setPageData(alienRegistrationList);
        meta.setMsg("获取外来人员登记列表成功");
        meta.setStatus(200);
        result.setData(page);
        result.setMeta(meta);
        return result;
    }

    @RequiresRoles(logical= Logical.OR, value = {"1","3"})
    @GetMapping("/{queryInfo}/{pageNum}/{pageSize}")
    public Result getAlienInfoByQuery(@PathVariable String queryInfo,@PathVariable int pageNum,@PathVariable int pageSize)
    {
        Meta meta=new Meta();
        Result result=new Result();
        Page page=new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        PageHelper.startPage(pageNum,pageSize);
        List<AlienRegistration> alienRegistrationList= alienRegistrationService.queryAlienInfo(queryInfo);
        PageInfo<AlienRegistration> pageInfo=new PageInfo<>(alienRegistrationList);
        page.setTotal(Integer.parseInt(pageInfo.getTotal()+""));
        page.setPageData(alienRegistrationList);
        meta.setMsg("查询外来人员登记列表成功");
        meta.setStatus(200);
        result.setData(page);
        result.setMeta(meta);

        return result;
    }

    @RequiresRoles(logical= Logical.OR, value = {"1","3"})
    @PutMapping
    public Result updateAlienInfo(@RequestBody AlienRegistration alienRegistration)
    {


        Result result=new Result();
        Meta meta=new Meta();
        if(alienRegistrationService.updateAlienInfo(alienRegistration)!=0)
        {
            meta.setMsg("更新外来人员信息成功");
            meta.setStatus(200);
            result.setMeta(meta);
        }else {
            meta.setMsg("更新外来人员信息失败");
            meta.setStatus(900);
            result.setMeta(meta);
        }

        return result;
    }
}
