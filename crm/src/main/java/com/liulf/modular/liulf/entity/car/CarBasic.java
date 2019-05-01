package com.liulf.modular.liulf.entity.car;

import lombok.Data;

/**
 * -- Car_Brand	品牌表
 * -- Car_MasterBrand	主品牌表
 * -- Car_MasterBrand_Rel	主品牌品牌关联表
 * -- Car_Producer	生产商数据表
 * -- Car_Serial	子品牌表  车系
 * -- Car_Basic	车型基本信息. 车款信息
 */
@Data
public class CarBasic {
    private Long Car_Id;// ` int(10) NOT NULL,
    private String Car_ProduceState;//` varchar(255) DEFAULT NULL,
    private String Car_SaleState;//` varchar(255) DEFAULT NULL,
    private Long Cs_Id;//` int(10) DEFAULT NULL,
    private String Car_Name;//` varchar(255) DEFAULT NULL,
    private String SpellFirst;//` varchar(255) DEFAULT NULL,
    private String car_ReferPrice;//` varchar(255) DEFAULT NULL,
    private String Car_YearType;//` varchar(255) DEFAULT NULL,
    private String IsState;//` varchar(255) DEFAULT NULL,
    private String IsLock;//` varchar(255) DEFAULT NULL,
    private String OLdCar_Id;//` varchar(255) DEFAULT NULL,
    private String CreateTime;//` varchar(255) DEFAULT NULL,
    private String UpdateTime;//` varchar(255) DEFAULT NULL,
    private String IsWagon;//` varchar(255) DEFAULT NULL,

}


