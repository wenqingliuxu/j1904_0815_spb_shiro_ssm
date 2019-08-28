package com.qf.j1904.mapper;


import com.qf.j1904.pojo.SysDrug;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLOutput;
import java.util.List;

@Mapper
public interface SysDrugMapper {

    /**
     * 查询所有药品信息
     * @return SysDrug
     */
    public List<SysDrug> findAll();


    /**
     *添加药品信息
     * @param sysDrug
     * @return
     */
    public int addDrugInfo(SysDrug sysDrug);

}
