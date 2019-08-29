package com.qf.j1904.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 对系统用户信息封装
 * Created by jeffrey on 2019/8/15.
 */
@Data
public class SysUser implements Serializable{
    private long userId;  //用户id
    private String loginName;//登陆名
    private String password;//密码（密文）
    private int state;//状态：1表示 用户有效；0表示被禁用户
    private Date createTime;//创建时间
    private String realname;//真实姓名
    private String doctorName;//主治医生姓名

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
