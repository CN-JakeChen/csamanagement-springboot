package com.jake.csamanagement.service;

import com.jake.csamanagement.dao.UserMapper;
import com.jake.csamanagement.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuService {

    @Autowired
    UserMapper userMapper;

    public List<Menu> getMenuList(String username) {
        String authName[] = {"数据管理", "用户管理", "寝室管理", "寝室卫生管理", "公寓人员出入管理", "统计"};
        String authName1[] = {"初始化导入"};
        String authName2[] = {"用户信息管理"};
        String authName3[] = {"寝室信息管理"};
        String authName4[] = {"寝室卫生成绩录入", "寝室卫生成绩管理"};
        String authName5[] = {"外来人员登记", "外来人员登记管理", "学生离校登记", "学生离校登记管理", "学生返校登记", "学生返校登记管理", "学生离校情况"};
        String authName6[] = {"统计"};
        String childAuthName[][] = {
                authName1, authName2, authName3, authName4, authName5, authName6
        };
        String path[] = {"data", "user", "room", "hygiene", "person", "statistics"};
        String childPath1[] = {"init-import"};
        String childPath2[] = {"users"};
        String childPath3[] = {"roominfo-management"};
        String childPath4[] = {"hygiene-add", "hygiene-management"};
        String childPath5[] = {"outperson-record", "outperson-management", "student-leave-record", "student-leave-management", "student-back-record", "student-back-managent", "student-leave-status"};
        String childPath6[] = {"statistics"};
        String childPath[][] = {
                childPath1, childPath2, childPath3, childPath4, childPath5, childPath6
        };
//
        Integer role = userMapper.getRoleByUsername(username);
//        Integer role = 3;
        List<Menu> menuList = new ArrayList<>();

        Map<Integer, Integer> adminMap = new HashMap<>();
        adminMap.put(1, 1);
        adminMap.put(2, 1);
        adminMap.put(3, 1);
        adminMap.put(4, 1);
        adminMap.put(5, 1);
        adminMap.put(6, 1);

        Map<Integer, Integer> teacherMap = new HashMap<>();
        teacherMap.put(1, 0);
        teacherMap.put(2, 0);
        teacherMap.put(3, 0);
        teacherMap.put(4, 0);
        teacherMap.put(5, 0);
        teacherMap.put(6, 1);

        Map<Integer, Integer> roomMap = new HashMap<>();
        roomMap.put(1, 0);
        roomMap.put(2, 0);
        roomMap.put(3, 1);
        roomMap.put(4, 1);
        roomMap.put(5, 1);
        roomMap.put(6, 0);

        Map<Integer, Integer> selectedMap = null;
        if (role == 1) {
            selectedMap = adminMap;
        } else if (role == 2) {
            selectedMap = teacherMap;
        } else if (role == 3) {
            selectedMap = roomMap;
        }


        for (int i = 0; i < authName.length; i++) {
            if (selectedMap.get(i + 1) == 1) {
                Menu menu = new Menu();
                menu.setId(i + 1);
                menu.setAuthName(authName[i]);
                menu.setPath(path[i]);
                List<Menu> childMenuList = new ArrayList<>();
                for (int j = 0; j < childAuthName[i].length; j++) {
                    Menu childMenu = new Menu();
                    childMenu.setId((i + 1) * 10 + j + 1);
                    childMenu.setAuthName(childAuthName[i][j]);
                    childMenu.setPath(childPath[i][j]);
                    childMenuList.add(childMenu);
                }
                menu.setChildren(childMenuList);
                menuList.add(menu);
            }


        }

        return menuList;

    }
}
