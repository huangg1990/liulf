package com.liulf.modular.liulf.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SpendCategory extends BaseEntity implements Serializable {
    private Long spend_category_id;//	类别ID
    private String spend_category_code; //编码
    private String spend_category_name;//	类别名称
}
