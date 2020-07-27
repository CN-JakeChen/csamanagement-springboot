package com.jake.csamanagement.controller;

import com.jake.csamanagement.model.LoginForm;
import com.jake.csamanagement.pojo.Meta;
import com.jake.csamanagement.pojo.Result;
import com.jake.csamanagement.entity.Token;
import com.jake.csamanagement.service.UserService;
import com.jake.csamanagement.util.JWTUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping
    public Result login(@RequestBody LoginForm loginForm)
    {
//        Subject subject= SecurityUtils.getSubject();
//        UsernamePasswordToken token=new UsernamePasswordToken(loginForm.getUsername(),loginForm.getPassword());
//        subject.login(token);

        Meta meta=new Meta();
        Result result=new Result();
        String realPassword=userService.getPasswordByUsername(loginForm.getUsername());
        if (realPassword == null) {
            meta.setMsg("用户名不存在");
            meta.setStatus(1000);
            result.setMeta(meta);
        } else if (!realPassword.equals(loginForm.getPassword())) {
            meta.setMsg("密码错误");
            meta.setStatus(1001);
            result.setMeta(meta);
        } else {
            meta.setStatus(200);
            Integer role=userService.getRoleByUsername(loginForm.getUsername());
            if (1==role) {
                meta.setMsg("系统管理员你好");
            }else if(2==role)
            {
                meta.setMsg("辅导员你好");
            }else if(3==role)
            {
                meta.setMsg("寝室管理员你好");
            }
            result.setMeta(meta);
            Token token=new Token();
            token.setToken(JWTUtil.createToken(loginForm.getUsername()));
            token.setRefreshToken(JWTUtil.createRefreshToken(loginForm.getUsername()));
            result.setData(token);
        }
        return result;
    }

    @GetMapping("/refresh/{rtoken}")
    public Result refresh(@PathVariable("rtoken") String rtoken)
    {
        System.out.println("调用刷新token接口");
        Result result=new Result();
        Token token=new Token();
        Meta meta=new Meta();
        String username=JWTUtil.getUsername(rtoken);
        if(JWTUtil.verifyRefresh(rtoken,username)==1)
        {
            System.out.println("rtoken验证成功");
            token.setToken(JWTUtil.createToken(username));
            token.setRefreshToken(rtoken);
            result.setData(token);
            meta.setStatus(200);
            meta.setMsg("刷新成功");
            result.setMeta(meta);
        }else {
            meta.setStatus(200);
            meta.setMsg("refeshtoken已过期，请重新登录");
            result.setMeta(meta);
        }
        return result;
    }


    @RequestMapping(value = "/notlogin",method=RequestMethod.GET)
    public Result notLogin()
    {
        Meta meta=new Meta();
        meta.setMsg("您尚未登录");
        meta.setStatus(9000);
        Result result=new Result();
        result.setMeta(meta);
        return result;
    }

    @RequestMapping(value = "/expired",method=RequestMethod.GET)
    public Result expired()
    {
        Meta meta=new Meta();
        meta.setMsg("token已过期");
        meta.setStatus(9001);
        Result result=new Result();
        result.setMeta(meta);
        return result;
    }

    @RequestMapping(value = "/error",method=RequestMethod.GET)
    public Result error()
    {
        Meta meta=new Meta();
        meta.setMsg("验证错误");
        meta.setStatus(9002);
        Result result=new Result();
        result.setMeta(meta);
        return result;
    }
}
