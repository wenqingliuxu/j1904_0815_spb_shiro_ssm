package com.qf.j1904.controller;

import com.qf.j1904.pojo.SysUser;
import com.qf.j1904.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by jeffrey on 2019/8/15.
 */
@Controller
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @RequestMapping(value="/index",method=RequestMethod.GET)
    public String showLoginForm(){
        return "index";
    }
    @RequestMapping(value="/dealLogin",method = RequestMethod.POST)
    public String login(@RequestParam("loginName") String loginName
            , @RequestParam("password") String password, HttpSession session){
        /**
         * 1、查询用户是否存在；
         * 2、用户存在查出用户信息，比对凭证；
         * 3、对输入的凭证信息加密与查出的凭证比较；
         * 4、凭证一致，根据用户名查询该用户的权限集合；
         * 5、将用户信息进行脱密后和权限信息存储（session）；
         * 6、返回登陆成功信息；
         * 使用shiro后，这些步骤统一交给shiro处理
         */
        session.setAttribute("loginName",loginName);
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
            subject.login(token);
            if(subject.isAuthenticated()){
                return "main";
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return "index";
    }
//    当用户权限不足时，访问的页面
    @RequestMapping("/unOauth")
    public String showUnOauth(){
        return "unAuth";
    }

//    用户登出时
    @RequestMapping("/logout")
    public String logout(){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();//用户登录（清除用户在shiro中的驻留信息）
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:login";
    }
//进入登录页面
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    //进入注册页面
    @RequestMapping("/zhuce")
    public String zhuce(){
        return "zhuce";
    }
    @RequestMapping("Main")
    public String goMain(){
        return "main";
    }
    //注册用户
    @RequestMapping("/zhuCe")
    public String zhucey(String loginName,String password){
        int hashIterations2 = 1024;
        String salt = "abc";
        Md5Hash md5Hash = new Md5Hash(password, salt, hashIterations2);
        String mima=md5Hash.toString();
        boolean bool=sysUserService.zhuCeUser(loginName,mima);
        boolean bool1=sysUserService.zhuCeRole(loginName);
        return bool1?"login":"error";
    }
    //进入角色分配页面
    @RequiresPermissions(value={"user_edit"})
    @RequestMapping("/role")
    public String role(Model model){
        List<SysUser> roleList1=sysUserService.loadYongHu();
        List<SysUser> roleList2=sysUserService.loadYiSheng();
        model.addAttribute("roleList1",roleList1);
        model.addAttribute("roleList2",roleList2);
        return "role";
    }
    //将用户角色修改为医生
    @RequestMapping("jiaRole")
    public String jiaRole(String loginName){
        sysUserService.updateRoleId(loginName);
        sysUserService.addRole(loginName);
        return "redirect:role";
    }
    //将医生角色修改为用户
    @RequestMapping("jianRole")
    public String jianRole(String loginName){
        sysUserService.updateRole(loginName);
        sysUserService.deleteRole(loginName);
        return "redirect:role";
    }
    //进入专家信息展示页面

    @RequestMapping("zhuanJias")
    public String zhuanJias(Model model){
        List<SysUser> zhuanjiaInfo=sysUserService.loadYiSheng();
        model.addAttribute("zhuanjiaInfo",zhuanjiaInfo);
        return "zhuanjias";
    }
    //进入用户信息管理页面
    @RequiresPermissions(value={"user_edit"})
    @RequestMapping("yonghus")
    public String yonghus(Model model){
        List<SysUser> roleList1=sysUserService.loadYongHu();
        model.addAttribute("roleList1",roleList1);
        return "yonghus";
    }
    //进入医生信息管理页面
    @RequiresPermissions(value={"user_edit"})
    @RequestMapping("yishengs")
    public String yishengs(Model model){
        List<SysUser> roleList2=sysUserService.loadYiSheng();
        model.addAttribute("roleList2",roleList2);
        return "yishengs";
    }
    @RequestMapping("guaHao")
    public String loadUserById(int userId,Model model){
        SysUser user=sysUserService.loadUserById(userId);
        model.addAttribute("user",user);
        return "guahao";
    }
    @RequestMapping("tiJiaoGuaHao")
    public String tiJiaoGuaHao(String loginName,HttpSession session){
       String lgName=(String)session.getAttribute("loginName");
        boolean bool=sysUserService.tiJiaoGH(lgName,loginName);
        return bool?"main":"index";
    }
    @RequestMapping("singleInfo")
    public String singleInfo(String loginName,HttpSession session,Model model){
        String lgName=(String)session.getAttribute("loginName");
        SysUser user=sysUserService.loadUserByLoginName(lgName);
        model.addAttribute("user",user);
        return "singleinfo";
    }
    @RequestMapping("queRen")
    public String queRen(){
        return "main";
    }
    @RequestMapping("fanHui")
    public String fanHui(){return "main";}
}
