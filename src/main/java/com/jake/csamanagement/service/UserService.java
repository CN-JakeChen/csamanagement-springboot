package com.jake.csamanagement.service;

import com.jake.csamanagement.dao.DeptMapper;
import com.jake.csamanagement.dao.UserMapper;
import com.jake.csamanagement.model.AddForm;
import com.jake.csamanagement.model.EditForm;
import com.jake.csamanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    DeptMapper deptMapper;

    public List<User> getUsers(String userName) {

        List<User> userList = userMapper.getUsers(userName);
        System.out.println(userList.size());
        for (User user : userList) {
            if(user.getDeptId()!=0)
            {
                user.setDeptName(deptMapper.getDepNametByDeptId(user.getDeptId()));
            }
            user.setFiledList(userMapper.getUserManField(user.getId()));
        }

        return userList;
    }

    public int addUser(AddForm addForm)
    {

       userMapper.insertUser(addForm);
       int id=addForm.getId();
       System.out.println("新生成的id:"+id);
       System.out.println("公寓选择数"+addForm.getManfield().size());
       for (Integer buildId:addForm.getManfield())
       {
           userMapper.insertUserMan(id,buildId);
       }
       return 1;
    }

    public int updateUser(EditForm editForm){
        return userMapper.updateUser(editForm);
    }

    public int DeleteUser(int userId){
        return userMapper.deleteUser(userId);
    }

    public Integer getRoleByUsername(String username)
    {
        return userMapper.getRoleByUsername(username);
    }

    public String getPasswordByUsername(String username)
    {
        return userMapper.getPasswordByUsername(username);
    }
}
