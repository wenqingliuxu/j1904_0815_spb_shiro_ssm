package com.qf.j1904.controller;


import com.qf.j1904.pojo.SysDrug;
import com.qf.j1904.service.SysDrugService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SysDrugController {
    @Autowired
    private SysDrugService sysDrugService;
//进入药品展示页面
    @RequestMapping("yaoPins")
    public String yaopins(Model model){
        List<SysDrug> drugInfo = sysDrugService.findAll();
        System.out.println(drugInfo);
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

}
