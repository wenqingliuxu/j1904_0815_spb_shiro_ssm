package com.qf.j1904.controller;


import com.qf.j1904.pojo.SysDrug;
import com.qf.j1904.service.SysDrugService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.sql.Date;
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

    //进入添加药品页面
    @RequestMapping("/addyaopin")
    public String tianjiapaopin(){

        return "addyaopin";
    }

    //进入增加结果页面（yaopinguanli）
    @RequestMapping("/addyaopinview")
    public String yaopinguanliyemian(
                                     String drug_Name,
                                     String drug_Features,
                                     Date drug_Date,
                                     int drug_Quantity,
                                     double drug_Price,
                                     String drug_AccName,
                                     String drug_Img
                                     ){
        SysDrug s = new SysDrug();
        s.setDrug_Name(drug_Name);
        s.setDrug_Features(drug_Features);
        s.setDrug_Date(drug_Date);
        s.setDrug_Quantity(drug_Quantity);
        s.setDrug_Price(drug_Price);
        s.setDrug_AccName(drug_AccName);
        s.setDrug_Img(drug_Img);
        int i = sysDrugService.addDrugInfo(s);;
        return i>0?"redirect:yaopinguanli":"error";


    }

    //进入删除结果页面
    @RequestMapping("/delyaopinview")
    public String gopiliangshanchu(@RequestParam("ids") List<Integer> Drug_Nums ){

        int i = sysDrugService.delDrugInfoByDrug_Nums(Drug_Nums);

        return i>0?"redirect:yaopinguanli":"error";

    }

    //进入修改药品信息 页面

    /*
        private int drug_Num;
        private String drug_Name;
        private String drug_Features;
        private Date drug_Date;
        private int  drug_Quantity;
        private double drug_Price;
        private String drug_AccName;
        private String drug_Img;*/
    @RequestMapping("/updateDrug_InfoByDrug_Num")
    public String godel(int drug_Num,Model model){
        System.out.println("--------------------------------"+drug_Num);
        SysDrug sysDrug = sysDrugService.findDrugInfoByDrug_Num(drug_Num);
        System.out.println("================================"+sysDrug);
        model.addAttribute("sysDrug",sysDrug);
        return "updateDrug_InfoByDrug_Num";

    }

    //进入修改结果页面
    @PostMapping("/updateDrug_InfoByDrug_Num_result")
    public String updateDrug_InfoByDrug_Num_result(SysDrug sysDrug){
        int i = sysDrugService.updatDrugeInfo(sysDrug);
        return i>0?"redirect:yaopinguanli":"error";
    }
    @RequestMapping("yaopinKuCun")
    public String yaopinKuCun(Model model){
        List<SysDrug> list=sysDrugService.findAll();
        System.out.println("===================================="+list);
        model.addAttribute("list",list);
        return "line-simple";
    }
}
