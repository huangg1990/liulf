package com.liulf.modular.liulf.entity.car;

import lombok.Data;

@Data
public class CarProducer {
    private Long Cp_Id;// int(10) NOT NULL,
    private String Cp_Name;// varchar(255) DEFAULT NULL,
    private String Cp_ShortName;// varchar(255) DEFAULT NULL,
    private String Cp_Byname;// varchar(255) DEFAULT NULL,
    private String Cp_EName;// varchar(255) DEFAULT NULL,
    private String Cp_Country;// varchar(255) DEFAULT NULL,
    private String Cp_Url;// varchar(255) DEFAULT NULL,
    private String Cp_Phone;// varchar(255) DEFAULT NULL,
    private String CreateTime;// varchar(255) DEFAULT NULL,
    private String Spell;// varchar(255) DEFAULT NULL,
    private String Cp_Introduction;// varchar(4096) DEFAULT NULL,
    private String Cp_LogoUrl;// varchar(255) DEFAULT NULL,
    private String IsState;// varchar(255) DEFAULT NULL,
    private String UpdateTime;// varchar(255) DEFAULT NULL,
    private String OldCp_Id;// varchar(255) DEFAULT NULL,
    private String CpSaleState;// varchar(255) DEFAULT NULL,
    private String cp_seoname;// varchar(255) DEFAULT NULL,
}
