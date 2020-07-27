package com.jake.csamanagement.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jake.csamanagement.entity.User;
import com.jake.csamanagement.model.AddForm;
import com.jake.csamanagement.model.EditForm;
import com.jake.csamanagement.pojo.Meta;
import com.jake.csamanagement.pojo.Page;
import com.jake.csamanagement.pojo.Result;
import com.jake.csamanagement.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequestMapping("/api/users")
@Api(description = "用户操作相关的API")
public class UserController {

    @Autowired
    UserService userService;

    @RequiresRoles("1")
    @PostMapping
    @ApiOperation(value = "添加新用户",httpMethod = "POST")
    public Result addUser(@RequestBody AddForm addForm) {

        for(Integer man:addForm.getManfield())
        {
            System.out.println("管理楼栋id:"+man);
        }
        Meta meta=new Meta();
        Result result=new Result();
        if (userService.addUser(addForm)==1)
        {
            meta.setMsg("添加用户成功");
            meta.setStatus(200);
            result.setMeta(meta);
            return result;
        }else {
            meta.setMsg("添加用户失败");
            meta.setStatus(1000);
            result.setMeta(meta);
            return result;
        }


    }

    @RequiresRoles("1")
    @DeleteMapping("/{userId}")
    @ApiOperation(value = "删除用户",httpMethod = "DELETE")
    @ApiImplicitParam(name = "userId",value = "用户id",required = true,dataType = "int")
    public Result deleteUser(@PathVariable("userId") int userId){
        Result result=new Result();
        Meta meta=new Meta();
        if(userService.DeleteUser(userId)==1)
        {
            meta.setMsg("删除用户成功");
            meta.setStatus(200);
            result.setMeta(meta);
            return result;
        }
        meta.setMsg("删除用户失败");
        meta.setStatus(1000);
        result.setMeta(meta);
        return result;
    }

    @RequiresRoles("1")
    @PutMapping
    @ApiOperation(value = "修改用户信息",httpMethod = "POST")
    public Result updateUser(@RequestBody EditForm editForm){
//        System.out.println("修改用户接口,请求id:"+userId);
//       System.out.println(editForm.getUserId());
//       System.out.println(editForm.getUsername());
//       System.out.println(editForm.getPassword());
        Meta meta=new Meta();
        Result result=new Result();
        if (userService.updateUser(editForm)==1)
        {
            meta.setMsg("更新用户信息成功");
            meta.setStatus(200);
            result.setMeta(meta);
            return result;
        }

        meta.setMsg("更新用户失败");
        meta.setStatus(1000);
        result.setMeta(meta);
        return result;
    }

    @RequiresRoles("1")
    @GetMapping("/{userName}/{pageNum}/{pageSize}")
    @ApiOperation(value = "获取规定条件的用户",httpMethod = "GET")
    public Result getUsers(@PathVariable("userName") String userName,@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize) {

        Page page=new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);

        PageHelper.startPage(pageNum,pageSize);
        List<User> userList=userService.getUsers(userName);
        PageInfo<User> pageInfo=new PageInfo<>(userList);
        page.setTotal(Integer.parseInt(pageInfo.getTotal()+""));
        page.setPageData(userList);
        Meta meta=new Meta();
        meta.setMsg("成功");
        meta.setStatus(200);
        Result result=new Result();
        result.setData(page);
        result.setMeta(meta);
//        System.out.println("获取所有用户接口");
        return result;
    }

    @RequiresRoles("1")
    @GetMapping("/{userId}")
    public void getUser(@PathVariable("userId") int userId){
        System.out.println("查询具体用户接口,请求Id:"+userId);
    }





}
