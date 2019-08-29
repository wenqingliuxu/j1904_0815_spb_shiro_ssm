package com.qf.j1904.controller;


import com.qf.j1904.pojo.SysDrug;
import com.qf.j1904.service.SysDrugService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SysDrugController {
    @Autowired
    private SysDrugService sysDrugService;
    //进入药品展示页面
    @RequestMapping("yaoPins")
    public String yaopins(Model model){
        List<SysDrug> drugInfo = sysDrugService.findAll();
        model.addAttribute("drugInfo",drugInfo);
        return "yaopins";
    }
    //进入药品管理页面
    @RequiresPermissions(value={"user_edit"})
    @RequestMapping("/yaopinguanli")
    public String yaopinguanli(Model model){
        List<SysDrug> drugInfo = sysDrugService.findAll();
        model.addAttribute("drugInfo",drugInfo);
        return "yaopinguanli";
    }
    //增加药品信息页面
    @RequestMapping("/addyaopin")
    public String show(){
        return "addyaopin";

    }




    //增加药品信息
    /*private int drug_Num;
    private String drug_Name;
    private String drug_Features;
    private Date drug_Date;
    private int  drug_Quantity;
    private double drug_Price;
    private String drug_AccName;
    private String drug_Img;*/
    @RequestMapping("/addyaopinview")
    public String addyaopin(String drug_Name, String drug_Features, Date drug_Date, int  drug_Quantity, double drug_Price, String drug_AccName, String drug_Img){
        SysDrug sysDrug1=new SysDrug();
        sysDrug1.setDrug_Name(drug_Name);
        sysDrug1.setDrug_Features(drug_Features);
        sysDrug1.setDrug_Date(drug_Date);
        sysDrug1.setDrug_Quantity(drug_Quantity);
        sysDrug1.setDrug_Price(drug_Price);
        sysDrug1.setDrug_AccName(drug_AccName);
        sysDrug1.setDrug_Img(drug_Img);
        System.out.println(sysDrug1);
        int i = sysDrugService.addDrugInfo(sysDrug1);

        return"redirect:yaopinguanli" /*i>0?"yaopins":"erroradd"*/;
    }


    //删除

    @RequestMapping("shanChu")
    public String delyaopinview(List<Integer> drug_Nums){
        System.out.println(drug_Nums+"======================打印ids==========================");

        int i = sysDrugService.delDrugInfoByDrug_Nums(drug_Nums);
        return i>0?"redirect:yaopinguanli":"error";
    }


}
