package com.jake.csamanagement.service;

import com.jake.csamanagement.dao.ImportMapper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
@Transactional
public class ImportService {

    @Autowired
    ImportMapper importMapper;




    //第一次导入初始化
    public void getInitExcel(String filename, MultipartFile excelfile) throws IOException {
//        判断word版本
        boolean isExcel2003 = true;
        if (filename.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        boolean notNull = false;

//        获取excel内容
        InputStream is = excelfile.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);

        }


        System.out.println("sheet数量："+wb.getNumberOfSheets());



//       遍历sheet
        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
//            判断sheet是否为空
            Sheet sheet = wb.getSheetAt(i);
            if (sheet != null) {
                notNull = true;
            }
            System.out.println("sheet"+i+"记录数量："+sheet.getLastRowNum());
            //遍历行
            for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                Row row = sheet.getRow(j);//通过sheet表单对象得到j+1行对象
//                如果中间有空格就跳过
                if (row == null && row.equals("")) {
                    continue;
                }
                //            判断如果出现多余空白行则跳过
                if (row.getCell(0).getStringCellValue().equals("") || row.getCell(0).getStringCellValue() == null) {
                    System.out.println("有空白行");
                    continue;
                }

                switch (i) {

                    case 0:
                        //处理sheet0的数据
                        int deptId = (int) row.getCell(1).getNumericCellValue();
                        String deptName = row.getCell(0).getStringCellValue();
                        System.out.println(deptId + "," + deptName);
                        importMapper.insertDept(deptId,deptName);
                        break;
                    case 1:
                        //处理sheet1的数据
                        int classId=(int) row.getCell(1).getNumericCellValue();
                        String className=row.getCell(0).getStringCellValue();
                        int year=(int) row.getCell(2).getNumericCellValue();
                        int mdeptId=(int) row.getCell(4).getNumericCellValue();
                        System.out.println(classId+","+className+","+year+","+mdeptId);
                        importMapper.insertClass(classId,className,year,mdeptId);
                        break;
                    case 2:
                        //处理sheet2的数据
                        int buildId=(int) row.getCell(1).getNumericCellValue();
                        String buildNumber=row.getCell(0).getStringCellValue();
                        System.out.println(buildId+","+buildNumber);
                        importMapper.insertBuild(buildId,buildNumber);
                        break;
                    case 3:
                        //处理sheet3的数据
                        int roomId=(int) row.getCell(2).getNumericCellValue();
                        int rbuildId=(int) row.getCell(3).getNumericCellValue();
                        String roomNumber=row.getCell(1).getStringCellValue();
                        System.out.println(roomId+","+rbuildId+","+roomNumber);
                        importMapper.insertRoom(roomId,rbuildId,roomNumber);
                        break;
                    case 4:
                        //处理sheet4的数据
                        String studentId=row.getCell(1).getStringCellValue();
                        String name=row.getCell(0).getStringCellValue();
                        int sclassId=(int) row.getCell(3).getNumericCellValue();
                        int sroomId=(int) row.getCell(6).getNumericCellValue();
                        int bedNumber=(int) row.getCell(7).getNumericCellValue();
                        System.out.println(studentId+","+name+","+sclassId+","+sroomId+","+bedNumber);
                        importMapper.insertStudent(studentId,name,sclassId,sroomId,bedNumber);
                        break;
                }
            }
        }

        System.out.println("导入成功");
    }


}
