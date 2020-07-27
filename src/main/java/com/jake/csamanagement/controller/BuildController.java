package com.jake.csamanagement.controller;

import com.jake.csamanagement.pojo.Meta;
import com.jake.csamanagement.pojo.Result;
import com.jake.csamanagement.service.BuildService;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/builds")

@Api(description = "获取楼栋信息相关的API")
public class BuildController {
    @Autowired
    BuildService buildService;

    //    @RequiresRoles("3")
//    @RequiresRoles(logical= Logical.OR, value = {"2","3"})
    @RequiresRoles(logical = Logical.OR, value = {"1", "3"})
    @GetMapping
    public Result getBuilds() {
        Meta meta = new Meta();
        meta.setMsg("获取楼栋信息成功");
        meta.setStatus(200);
        Result result = new Result();
        result.setData(buildService.getBuilds());
        result.setMeta(meta);
        return result;
    }
}
