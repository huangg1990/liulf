package com.liulf.crm.modular.crm.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.liulf.crm.core.common.annotion.Permission;
import com.liulf.crm.core.common.constant.Const;
import com.liulf.crm.modular.crm.entity.SysCity;
import com.liulf.crm.modular.crm.service.SysCityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sys_city")
public class SysCityController extends BaseController {

    @Autowired
    SysCityService sysCityService;

    private static final Logger log = LoggerFactory.getLogger(SysCityController.class);

    @RequestMapping("/listdata")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Object list(@RequestParam(required = false) int levelType,
                       @RequestParam(required = false) String pid) {
        return getCityList(levelType, pid);
    }

    private Object getCityList(@RequestParam(required = false) int levelType, @RequestParam(required = false) String pid) {
        log.info("pid {}", pid);

        List<SysCity> mstCommunityList = sysCityService.getSysCityByLevelTypeAndPid(levelType, Integer.valueOf(pid));

        Map<String, Object> map = new HashMap<>();
        List<JSONObject> data = new ArrayList<>();
        if (mstCommunityList != null) {
            for (SysCity item : mstCommunityList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("value", item.getId());
                jsonObject.put("name", item.getCity_name());
                data.add(jsonObject);
            }
        }

        map.put("status", 200);
        map.put("data", data);
        return map;
    }


}