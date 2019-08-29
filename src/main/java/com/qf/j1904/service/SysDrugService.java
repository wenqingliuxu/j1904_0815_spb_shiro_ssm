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


    /**
     * 根据传入的drug_Nums集合来删除药品信息
     * @param drug_Nums
     * @return
     */
    public int delDrugInfoByDrug_Nums(List<Integer> drug_Nums);


    /**
     * 根据num修改药品信息
     * @param sysDrug
     * @return int(数据库受影响的行数)
     */
    public int updatDrugeInfo(SysDrug sysDrug);

    /**
     * findDrugInfoByDrug_Num
     * @param Drug_Num
     * @return SysDrug 对象
     */
    public SysDrug findDrugInfoByDrug_Num(Integer Drug_Num);
}
