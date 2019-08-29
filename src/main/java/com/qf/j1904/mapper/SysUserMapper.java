package com.qf.j1904.mapper;

import com.qf.j1904.pojo.SysDrug;
import com.qf.j1904.pojo.SysPermission;
import com.qf.j1904.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.List;

/**
 * 提供权限系统对外访问的数据请求
 * Created by jeffrey on 2019/8/15.
 */
@Mapper
public interface SysUserMapper {
    /**
     * 根据登录名查询用户信息
     * @param loginName  登录名
     * @return   SysUser 用户对象信息
     */
    public SysUser  findUserInfoByLoginName(@Param("loginName") String loginName);

    /**
     * 根据用户名查询该用户已分配的权限集合
     * @param loginName  登录名（用户名）
     * @return  SysPermission对象的集合
     */
    public List<SysPermission>  findPermissionsByUserName(String loginName);
//查询所有患者信息
    public List<SysUser> loadYongHu();
//查询所有医生信息
    public List<SysUser> loadYiSheng();

    /**
     * 注册用户
     * @param loginName 用户名
     * @param mima 用户密码
     * @return
     */
    public int zhuCeUser(String loginName,String mima);

    /**
     * 根据用户名查询用户id，添加用户角色
     * @param loginName 用户名
     * @return
     */
    public int zhuCeRole(String loginName);

    /**
     * 将用户角色修改为管理员
     * @param loginName 用户名
     * @return
     */
    public int addRole(String loginName);

    /**
     * 将用户角色修改为患者
     * @param loginName
     * @return
     */
    public int deleteRole(String loginName);

    /**
     * 将用户roleid 修改为1，管理员
     * @param loginName
     * @return
     */
    public int updateRoleId(String loginName);

    /**
     * 将用户roleid修改为2，普通患者
     * @param loginName
     * @return
     */
    public int updateRole(String loginName);

    /**
     * 通过用户id查询用户信息
     * @param userId
     * @return
     */
    public SysUser loadUserById(int userId);

    public int tiJiaoGH(String lgName,@Param("loginName") String loginName);

    public SysUser loadUserByLoginName(String loginName);
}
