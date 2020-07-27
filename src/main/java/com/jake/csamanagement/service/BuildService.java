package com.jake.csamanagement.service;

import com.jake.csamanagement.dao.BuildMapper;
import com.jake.csamanagement.entity.Build;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildService {
    @Autowired
    BuildMapper buildMapper;
    public List<Build> getBuilds(){
        return buildMapper.getBuilds();
    }

}
