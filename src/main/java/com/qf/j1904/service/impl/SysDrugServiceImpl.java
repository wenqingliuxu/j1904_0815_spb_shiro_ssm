package com.qf.j1904.service.impl;

import com.qf.j1904.mapper.SysDrugMapper;
import com.qf.j1904.pojo.SysDrug;
import com.qf.j1904.service.SysDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysDrugServiceImpl implements SysDrugService {

    @Autowired
    private SysDrugMapper sysDrugMapper;

    /**
     * 加载所有
     * @return
     */
    @Override
    public List<SysDrug> findAll() {

        List<SysDrug> sysDrugs = sysDrugMapper.findAll();
        return sysDrugs;
    }

    /**
     * 添加药品信息
     * @param sysDrug
     * @return
     */
    @Override
    public int addDrugInfo(SysDrug sysDrug) {
        int i = sysDrugMapper.addDrugInfo(sysDrug);
        return i;
    }

    /**
     * 根据传入的drug_Nums集合来删除药品信息
     * @param drug_Nums
     * @return 受影响的行数
     */
    @Override
    public int delDrugInfoByDrug_Nums(List<Integer> drug_Nums) {
        int i = sysDrugMapper.delDrugInfoByDrug_Nums(drug_Nums);
        return i;
    }


    /**
     * 传入对象返回受影响的行数
     * @param sysDrug
     * @return
     */
    @Override
    public int updatDrugeInfo(SysDrug sysDrug) {
        int i = sysDrugMapper.updatDrugeInfo(sysDrug);
        return i;
    }

    /**
     * findDrugInfoByDrug_Num
     * @param Drug_Num
     * @return infoByDrugNum 对象
     */
    @Override
    public SysDrug findDrugInfoByDrug_Num(Integer Drug_Num) {
        SysDrug infoByDrugNum = sysDrugMapper.findDrugInfoByDrug_Num(Drug_Num);
        return infoByDrugNum;
    }


}
