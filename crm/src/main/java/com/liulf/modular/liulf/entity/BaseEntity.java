package com.liulf.modular.liulf.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class BaseEntity implements Serializable {
    protected String note;//备注
    protected Character delete_flag;//	删除标识
    protected Date create_time;//	创建时间
    protected Long create_user;//	创建用户id
    protected Date update_time;//	修改时间
    protected Long update_user;//	修改用户ID

}
