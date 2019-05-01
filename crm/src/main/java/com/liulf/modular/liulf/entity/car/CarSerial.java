package com.liulf.modular.liulf.entity.car;

import lombok.Data;

@Data
public class CarSerial {
    private Long cs_Id;// int(10) NOT NULL,
    private Long cb_Id;// int(10) DEFAULT NULL,
    private String cs_Name;// varchar(128) DEFAULT NULL,
    private String cs_OtherName;// varchar(256) DEFAULT NULL,
    private String cs_EName;// varchar(128) DEFAULT NULL,
    private String cs_Url;// varchar(256) DEFAULT NULL,
    private String cs_Phone;// varchar(64) DEFAULT NULL,
    private String cs_Introduction;// varchar(4096) DEFAULT NULL,
    private String cs_Tag;// varchar(256) DEFAULT NULL,
    private String cs_Photo;// varchar(128) DEFAULT NULL,
    private String cs_Virtues;// varchar(4096) DEFAULT NULL,
    private String cs_Defect;// varchar(2048) DEFAULT NULL,
    private String spell;// varchar(255) DEFAULT NULL,
    private String CreateTime;// varchar(255) DEFAULT NULL,
    private String cs_CarType;// varchar(255) DEFAULT NULL,
    private String cs_Cliques;// varchar(255) DEFAULT NULL,
    private String prototypeCar;// varchar(255) DEFAULT NULL,
    private String cs_CarLevel;// varchar(255) DEFAULT NULL,
    private String IsState;// varchar(255) DEFAULT NULL,
    private String OldCb_Id;// varchar(255) DEFAULT NULL,
    private String UpdateTime;// varchar(255) DEFAULT NULL,
    private String CsSaleState;// varchar(255) DEFAULT NULL,
    private String cs_ShowName;// varchar(255) DEFAULT NULL,
    private String allSpell;// varchar(255) DEFAULT NULL,
    private String CsPurpose;// varchar(255) DEFAULT NULL,
    private String CsBodyForm;// varchar(255) DEFAULT NULL,
    private String cs_seoname;// varchar(255) DEFAULT NULL,
    private String CsRepairPolicy;// varchar(255) DEFAULT NULL,
    private String ModelLevelSecond;// varchar(255) DEFAULT NULL,
    private String Remarks;// varchar(255) DEFAULT NULL,
    private String Weight;// varchar(255) DEFAULT NULL,
}
