package com.qf.j1904;

import com.qf.j1904.mapper.SysUserMapper;
import com.qf.j1904.pojo.SysDrug;
import com.qf.j1904.pojo.SysUser;
import com.qf.j1904.service.SysDrugService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class J19040815SpbShiroSsmApplicationTests {
    @Autowired
    SysUserMapper sysUserMapper;
    @Test
    public void contextLoads() {
        SysUser test = sysUserMapper.findUserInfoByLoginName("test");
        System.out.println(test);
    }


    @Autowired
    private SysDrugService sysDrugService;

    @Test
    public void addDrugInfo() {

        String drug_Name = "a";           /*    varchar(50) NULL*/
        String drug_Features = "a";       /*    varchar(100) NULL*/
        Date drug_Date = new Date(1111 - 11 - 11);    /*          date NULL*/
        int drug_Quantity = 11;                       /*       int(50) NULL*/
        int drug_Price = 11;                          /*  double(7,2) NULL*/
        String drug_AccName = "周";                    /*           varchar(50) NULL*/
        String drug_Img = "a/a/a";                    /*            varchar(90) NULL*/
        System.out.println("=========================new SysDrug之前=========");
        SysDrug sysDrug = new SysDrug();

        sysDrug.setDrug_Name(drug_Name);
        sysDrug.setDrug_Features(drug_Features);
        sysDrug.setDrug_Date(drug_Date);
        sysDrug.setDrug_Quantity(drug_Quantity);
        sysDrug.setDrug_Price(drug_Price);
        sysDrug.setDrug_AccName(drug_AccName);
        sysDrug.setDrug_Img(drug_Img);

        int i = sysDrugService.addDrugInfo(sysDrug);
        System.out.println("====================添加成功======================"+i);

    }




    @Test
    public void delDrugInfoByDrug_Nums(){
        List<Integer> num=new ArrayList<>();
        num.add(6);
        num.add(7);

        System.out.println(num+"===========================================================");
        int i = sysDrugService.delDrugInfoByDrug_Nums(num);
        System.out.println(i);
        System.out.println("================删除 除成功=====================================");
    }
    @Test
    public void updatDrugeInfo(){
        SysDrug drugInfoByDrug_num = sysDrugService.findDrugInfoByDrug_Num(13);
        int i = sysDrugService.updatDrugeInfo(drugInfoByDrug_num);

        System.out.println(i);
        System.out.println("=======================修改成功=========================");

    }


    @Test
    public void findDrugInfoByDrug_Num(){

        SysDrug drugInfoByDrug_num = sysDrugService.findDrugInfoByDrug_Num(8);

        System.out.println(drugInfoByDrug_num);
        System.out.println("=======================查询成功===========================");
    }


}
