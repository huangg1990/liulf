package com.liulf.modular.liulf.controller.ext;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.liulf.modular.liulf.entity.NameValue;
import com.liulf.modular.liulf.service.ext.ExtDeptService;
import com.liulf.modular.system.entity.Dept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/extdept")
public class ExtDeptController {
    private static final Logger log = LoggerFactory.getLogger(ExtDeptController.class);
    @Autowired
    ExtDeptService extdeptService;

    @RequestMapping("/select")
    @ResponseBody
    public Object getdeptList( String pcode  ) {

        if (ToolUtil.isEmpty(pcode)) {
            //throw new RequestEmptyException("参数错误！");
        }
        Map<String, Object> map = new HashMap<>();
        try{
            List<Dept> list= extdeptService.getDeptListByPCode(pcode);

            List<NameValue> data=NameValue.ListDept2ListNameValue(list);

            map.put("status", 200);
            map.put("data", data);
        }catch (Exception e){
            log.error("/extdept/list",e);
        }

        return map;
    }
}
