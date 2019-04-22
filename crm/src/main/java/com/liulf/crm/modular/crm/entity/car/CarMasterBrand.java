package com.liulf.crm.modular.crm.entity.car;

import lombok.Data;

@Data
public class CarMasterBrand {
    private Long bs_Id;// int(10) NOT NULL,
    private String bs_Name;// varchar(255) DEFAULT NULL,
    private String bs_OtherName;// varchar(255) DEFAULT NULL,
    private String bs_Country;// varchar(255) DEFAULT NULL,
    private String bs_EName;// varchar(255) DEFAULT NULL,
    private String bs_Logo;// varchar(255) DEFAULT NULL,
    private String bs_Logo_2;// varchar(255) DEFAULT NULL,
    private String bs_LogoInfo;// varchar(4096) DEFAULT NULL,
    private String spell;// varchar(255) DEFAULT NULL,
    private String CreateTime;// varchar(255) DEFAULT NULL,
    private String IsState;// varchar(255) DEFAULT NULL,
    private String UpdateTime;// varchar(255) DEFAULT NULL,
    private String IsLock;// varchar(255) DEFAULT NULL,
    private String urlspell;// varchar(255) DEFAULT NULL,
    private String bs_introduction;// varchar(4096) DEFAULT NULL,
    private String bs_seoname;// varchar(255) DEFAULT NULL,
    private String BrandType;// varchar(255) DEFAULT NULL,
    private String GrandBrand;// varchar(255) DEFAULT NULL,
    private String Remarks;// varchar(255) DEFAULT NULL,
    private String Weight;// varchar(255) DEFAULT NULL,
    private String KeyBrand;// varchar(255) DEFAULT NULL,

}
