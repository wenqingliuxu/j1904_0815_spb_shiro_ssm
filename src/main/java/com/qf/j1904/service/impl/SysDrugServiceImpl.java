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
}
