package com.qf.j1904.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

    public int getDrug_Num() {
        return drug_Num;
    }

    public void setDrug_Num(int drug_Num) {
        this.drug_Num = drug_Num;
    }

    public String getDrug_Name() {
        return drug_Name;
    }

    public void setDrug_Name(String drug_Name) {
        this.drug_Name = drug_Name;
    }

    public String getDrug_Features() {
        return drug_Features;
    }

    public void setDrug_Features(String drug_Features) {
        this.drug_Features = drug_Features;
    }

    public Date getDrug_Date() {
        return drug_Date;
    }

    public void setDrug_Date(Date drug_Date) {
        this.drug_Date = drug_Date;
    }

    public int getDrug_Quantity() {
        return drug_Quantity;
    }

    public void setDrug_Quantity(int drug_Quantity) {
        this.drug_Quantity = drug_Quantity;
    }

    public double getDrug_Price() {
        return drug_Price;
    }

    public void setDrug_Price(double drug_Price) {
        this.drug_Price = drug_Price;
    }

    public String getDrug_AccName() {
        return drug_AccName;
    }

    public void setDrug_AccName(String drug_AccName) {
        this.drug_AccName = drug_AccName;
    }

    public String getDrug_Img() {
        return drug_Img;
    }

    public void setDrug_Img(String drug_Img) {
        this.drug_Img = drug_Img;
    }
}
