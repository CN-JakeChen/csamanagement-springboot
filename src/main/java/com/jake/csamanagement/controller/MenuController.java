package com.jake.csamanagement.controller;

import com.jake.csamanagement.pojo.Meta;
import com.jake.csamanagement.pojo.Result;
import com.jake.csamanagement.service.MenuService;
import com.jake.csamanagement.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/menus")
public class MenuController {

    @Autowired
    MenuService menuService;


    @GetMapping
    public Result getMenuList(@RequestHeader("Token") String token){
        Result result=new Result();
        result.setData(menuService.getMenuList(JWTUtil.getUsername(token)));
        Meta meta=new Meta();
        meta.setStatus(200);
        meta.setMsg("成功");
        result.setMeta(meta);
        return result;
    }
}
