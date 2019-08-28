package com.qf.j1904.service;

import com.qf.j1904.pojo.SysPermission;
import com.qf.j1904.pojo.SysUser;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.List;

/**
 * Created by jeffrey on 2019/8/15.
 */
public interface SysUserService {
    /**
     *
     * @param loginName
     * @return
     */
    public SysUser findUserByLoginName(String loginName);

    /**
     *
     * @param loginName
     * @return
     */
    public List<SysPermission> findPermissionsByLoginName(String loginName);
    public List<SysUser> loadYongHu();
    public List<SysUser> loadYiSheng();
    public boolean zhuCeUser(String loginName, String mima);
    public boolean zhuCeRole(String loginName);

    public boolean addRole(String loginName);
    public boolean deleteRole(String loginName);
    public boolean updateRoleId(String loginName);
    public boolean updateRole(String loginName);
}
