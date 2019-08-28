package com.qf.j1904.service.impl;

import com.qf.j1904.mapper.SysUserMapper;
import com.qf.j1904.pojo.SysPermission;
import com.qf.j1904.pojo.SysUser;
import com.qf.j1904.service.SysUserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jeffrey on 2019/8/15.
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper userMapper;
    @Override
    public SysUser findUserByLoginName(String loginName) {
        SysUser sysUser = userMapper.findUserInfoByLoginName(loginName);
        return sysUser;
    }

    @Override
    public List<SysPermission> findPermissionsByLoginName(String loginName) {
        List<SysPermission> permissions = userMapper.findPermissionsByUserName(loginName);
        return permissions;

    }

    @Override
    public List<SysUser> loadYongHu() {
        List<SysUser> roleList1 = userMapper.loadYongHu();
        return roleList1;
    }

    @Override
    public List<SysUser> loadYiSheng() {
        List<SysUser> roleList2 = userMapper.loadYiSheng();
        return roleList2;
    }

    @Override
    public boolean zhuCeUser(String loginName, String mima) {
        int count=0;
        count=userMapper.zhuCeUser(loginName,mima);
        return count>0?true:false;
    }

    @Override
    public boolean zhuCeRole(String loginName) {
        int count=0;
        count=userMapper.zhuCeRole(loginName);
        return count>0?true:false;
    }

    @Override
    public boolean addRole(String loginName) {
        int count=0;
        count=userMapper.addRole(loginName);
        return count>0?true:false;
    }

    @Override
    public boolean deleteRole(String loginName) {
        int count=0;
        count=userMapper.deleteRole(loginName);
        return count>0?true:false;
    }
    @Override
    public boolean updateRoleId(String loginName){
        int count=0;
        count=userMapper.updateRoleId(loginName);
        return count>0?true:false;
    }
    @Override
    public boolean updateRole(String loginName){
        int count=0;
        count=userMapper.updateRole(loginName);
        return count>0?true:false;
    }

}
