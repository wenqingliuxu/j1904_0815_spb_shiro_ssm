package com.qf.j1904.service;

import com.qf.j1904.pojo.SysDrug;

import java.util.List;


public interface SysDrugService {

    /**
     * 查所有
     * @return SysDrug
     */
    public List<SysDrug> findAll();

    /**
     * 添加药品信息
     * @param sysDrug
     * @return
     */
    public int addDrugInfo(SysDrug sysDrug);

}
