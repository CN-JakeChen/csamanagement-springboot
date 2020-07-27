package com.jake.csamanagement.controller;

import com.jake.csamanagement.entity.User;
import com.jake.csamanagement.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired TestService tservice;

    @RequestMapping(value = "/t",method = RequestMethod.POST)
    public User test(@RequestParam(value = "username")String username){
        System.out.println(username);
        System.out.println("ok");
        return tservice.getUser(username);
    }
    @RequestMapping("t1")
    public void test1()
    {
        tservice.t1();
    }

    @RequestMapping("t2")
    public void test2()
    {
        tservice.t2();
    }

    @RequestMapping("testpage")
    public void testPage(){
        tservice.pageTest();
    }
}
