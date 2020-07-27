package com.jake.csamanagement.controller;

import com.jake.csamanagement.service.ImportService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController

@RequestMapping("/import")
public class ImportController {

    @Autowired
    ImportService importService;

    @RequiresRoles("1")
    @RequestMapping(value = "/initfile",method = RequestMethod.POST)
    public void importInitExcel(@RequestParam(value = "file")MultipartFile excelfile)
    {
//       获取文件名
        String filename=excelfile.getOriginalFilename();
        System.out.println("到达init,"+excelfile.getOriginalFilename());
        try {
            importService.getInitExcel(filename,excelfile);
        }catch (IOException e)
        {
            System.out.println("导入失败");
            e.printStackTrace();
        }

    }

    @RequiresRoles("1")
    @RequestMapping(value = "/updatefile",method = RequestMethod.POST)
    public void importUpdateExcel(@RequestParam(value = "file")MultipartFile excelfile)
    {
        System.out.println("到达update,"+excelfile.getOriginalFilename());
    }
}
