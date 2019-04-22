package com.liulf.crm.modular.crm.entity;


import com.liulf.crm.modular.system.entity.Dict;

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
}
