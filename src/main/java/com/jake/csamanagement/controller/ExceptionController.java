package com.jake.csamanagement.controller;

import com.jake.csamanagement.pojo.Meta;
import com.jake.csamanagement.pojo.Result;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AccountException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionController {

    // 捕捉 CustomRealm 抛出的异常
    @ExceptionHandler(AccountException.class)
    public Result handleShiroException(Exception ex) {
        Meta meta=new Meta();
        meta.setStatus(1000);
//        meta.setMsg(ex.getMessage());
        meta.setMsg("账户服务异常");
        Result result=new Result();
        result.setMeta(meta);
        return result;
    }

    // 捕捉shiro的异常
    @ExceptionHandler(ShiroException.class)
    public Result handle401() {
        Meta meta=new Meta();
        meta.setStatus(1000);
        meta.setMsg("您没有权限访问");
        Result result=new Result();
        result.setMeta(meta);
        return result;
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    public Result globalException(HttpServletRequest request, Throwable ex) {
        Meta meta=new Meta();
        meta.setStatus(1000);
//        meta.setMsg("访问出错，无法访问: " + ex.getMessage());
        meta.setMsg("访问出错，无法访问，请稍后再试");
        Result result=new Result();
        result.setMeta(meta);
        return result;
    }
}
