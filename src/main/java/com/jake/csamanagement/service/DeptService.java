package com.jake.csamanagement.service;

import com.jake.csamanagement.dao.DeptMapper;
import com.jake.csamanagement.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    @Autowired
    DeptMapper deptMapper;
    public List<Dept> getDepts()
    {
        Dept dept=new Dept();
        dept.setDeptId(0);
        dept.setDeptName("请选择");
        List<Dept> deptList;
        deptList=deptMapper.getDepts();
        deptList.add(dept);
        return deptList;
    }
}
