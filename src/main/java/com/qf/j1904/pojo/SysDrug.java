package com.qf.j1904.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 FieldTypeComment

 drug_Num int(11) NOT NULL
 drug_Name varchar(50) NULL
 drug_Features  varchar(100) NULL
 drug_Date   date NULL
 drug_Quantity  int(50) NULL
 drug_Price  double(7,2) NULL
 drug_AccName  varchar(50) NULL
 *
 *
 */

@Data
public class SysDrug implements Serializable {
    private int drug_Num;
    private String drug_Name;
    private String drug_Features;
    private Date drug_Date;
    private int  drug_Quantity;
    private double drug_Price;
    private String drug_AccName;
    private String drug_Img;
}
