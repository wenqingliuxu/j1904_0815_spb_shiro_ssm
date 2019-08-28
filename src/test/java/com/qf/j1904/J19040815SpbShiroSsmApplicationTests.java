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

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class J19040815SpbShiroSsmApplicationTests {
    /*@Autowired
	SysUserMapper sysUserMapper;
	@Test
	public void contextLoads() {
		SysUser test = sysUserMapper.findUserInfoByLoginName("test");
		System.out.println(test);
	}*/


    @Autowired
    private SysDrugService sysDrugService;

    @Test
    public void addDrugInfo() {

        String drug_Name = "a";               /*varchar(50) NULL*/
        String drug_Features = "a";           /*varchar(100) NULL*/
        Date drug_Date = new Date(1111 - 11 - 11);      /*        date NULL*/
        int drug_Quantity = 11;                      /*        int(50) NULL*/
        int drug_Price = 11;                        /*    double(7,2) NULL*/
        String drug_AccName = "周";                       /*        varchar(50) NULL*/
        String drug_Img = "a/a/a";                        /*        varchar(90) NULL*/
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

}
