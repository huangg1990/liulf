package com.liulf.crm.modular.crm.entity;


import com.liulf.crm.modular.system.entity.Dept;
import com.liulf.crm.modular.system.entity.Dict;
import com.liulf.crm.modular.system.entity.User;

import java.util.ArrayList;
import java.util.List;

public class NameValue {
    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public static List<NameValue> ListDict2ListNameValue(List<Dict> dictList){
        List<NameValue> data=new ArrayList<>();
        if(dictList==null || dictList.size()==0)
            return  data;
        if(dictList!=null && dictList.size()>0){
            for(Dict dict: dictList){
                NameValue nameValue=new NameValue();
                nameValue.setName(dict.getName());
                nameValue.setValue(dict.getCode());
                data.add(nameValue);
            }
        }
        return data;
    }

    public static List<NameValue> ListDept2ListNameValue(List<Dept> list){
        List<NameValue> data=new ArrayList<>();
        if(list==null || list.size()==0)
            return  data;
        if(list!=null && list.size()>0){
            for(Dept entity: list){
                NameValue nameValue=new NameValue();
                nameValue.setName(entity.getFullName());
                nameValue.setValue(entity.getDeptId().toString());
                data.add(nameValue);
            }
        }
        return data;
    }

    public static List<NameValue> ListUser2ListNameValue(List<User> list){
        List<NameValue> data=new ArrayList<>();
        if(list==null || list.size()==0)
            return  data;
        if(list!=null && list.size()>0){
            for(User entity: list){
                NameValue nameValue=new NameValue();
                nameValue.setName(entity.getName());
                nameValue.setValue(entity.getUserId().toString());
                data.add(nameValue);
            }
        }
        return data;
    }

}
