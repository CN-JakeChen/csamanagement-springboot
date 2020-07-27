package com.jake.csamanagement.controller;

import com.jake.csamanagement.pojo.Meta;
import com.jake.csamanagement.pojo.Result;
import com.jake.csamanagement.service.StatisticsService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("api/statistics")
public class StatisticsController {
    @Autowired
    StatisticsService statisticsService;

    @RequiresRoles(logical= Logical.OR, value = {"1","2"})
    @GetMapping("/{type}")
    public Result getStatistics(@PathVariable("type") int type) {
        Result result = new Result();
        Meta meta = new Meta();
        if (type == 1) {
            result.setData(statisticsService.getRoomRecordStatistics());
            meta.setMsg("获取寝室分数统计成功");
            meta.setStatus(200);
            result.setMeta(meta);
        } else if (type == 2) {
            result.setData(statisticsService.getAlienStatistics());
            meta.setMsg("获取外来人员人数统计成功");
            meta.setStatus(200);
            result.setMeta(meta);
        }


        return result;
    }


}
