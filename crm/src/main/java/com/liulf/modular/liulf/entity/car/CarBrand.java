package com.liulf.modular.liulf.entity.car;

import lombok.Data;

@Data
public class CarBrand {
    private Long cb_Id;// int(10) NOT NULL,
    private Long cp_Id;// int(10) DEFAULT NULL,
    private String cb_Name;// varchar(255) DEFAULT NULL,
    private String cb_OtherName;// varchar(255) DEFAULT NULL,
    private String cb_Country;// varchar(255) DEFAULT NULL,
    private String cb_EName;// varchar(255) DEFAULT NULL,
    private String cb_Phone;// varchar(255) DEFAULT NULL,
    private String cb_url;// varchar(255) DEFAULT NULL,
    private String cb_introduction;// varchar(4096) DEFAULT NULL,
    private String cb_Logo;// varchar(255) DEFAULT NULL,
    private String spell;// varchar(255) DEFAULT NULL,
    private String CreateTime;// varchar(255) DEFAULT NULL,
    private String IsState;// varchar(255) DEFAULT NULL,
    private String OldCs_Id;// varchar(255) DEFAULT NULL,
    private String UpdateTime;// varchar(255) DEFAULT NULL,
    private String CbSaleState;// varchar(255) DEFAULT NULL,
    private String allSpell;// varchar(255) DEFAULT NULL,
    private String brandPic;// varchar(255) DEFAULT NULL,
    private String cb_seoname;// varchar(255) DEFAULT NULL,
    private String Weight;// varchar(255) DEFAULT NULL,

}
