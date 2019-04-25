package com.liulf.crm.modular.crm.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.RequestEmptyException;
import com.alibaba.fastjson.JSONObject;
import com.liulf.crm.modular.crm.entity.car.CarBasic;
import com.liulf.crm.modular.crm.entity.car.CarBrand;
import com.liulf.crm.modular.crm.entity.car.CarSerial;
import com.liulf.crm.modular.crm.service.car.CarBasicService;
import com.liulf.crm.modular.crm.service.car.CarBrandService;
import com.liulf.crm.modular.crm.service.car.CarSerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/car")
public class CarController extends BaseController {

    @Autowired
    CarSerialService carSerialService;

    @Autowired
    CarBasicService carBasicService;

    @Autowired
    CarBrandService carBrandService;


    @RequestMapping("/car_brand_select")
    @ResponseBody
    public Object car_brand(String pid) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<CarBrand> carBrandList = carBrandService.getSelect();

            List<JSONObject> data = new ArrayList<>();
            if (carBrandList != null) {
                for (CarBrand item : carBrandList) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("value", item.getCb_Id());
                    jsonObject.put("name", item.getCb_Name());
                    data.add(jsonObject);
                }
            }

            map.put("status", 200);
            map.put("data", data);

        } catch (Exception e) {
            throw new RequestEmptyException("服务异常！");
        }

        return map;
    }


    @RequestMapping("/car_serial_select")
    @ResponseBody
    public Object car_serial(String pid) {

        if (ToolUtil.isEmpty(pid)) {
            throw new RequestEmptyException("参数错误！");
        }
        Map<String, Object> map = new HashMap<>();
        try {
            List<CarSerial> carSerialList = carSerialService.getSelectByCbId(pid);

            List<JSONObject> data = new ArrayList<>();
            if (carSerialList != null) {
                for (CarSerial item : carSerialList) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("value", item.getCs_Id());
                    jsonObject.put("name", item.getCs_Name());
                    data.add(jsonObject);
                }
            }

            map.put("status", 200);
            map.put("data", data);

        } catch (Exception e) {
            throw new RequestEmptyException("服务异常！");
        }

        return map;
    }

    @RequestMapping("/car_basic_select")
    @ResponseBody
    public Object carBasic(String pid) {

        if (ToolUtil.isEmpty(pid)) {
            throw new RequestEmptyException("参数错误！");
        }
        Map<String, Object> map = new HashMap<>();
        try {
            List<CarBasic> carBasicList = carBasicService.getSelectByCsId(pid);

            List<JSONObject> data = new ArrayList<>();
            if (carBasicList != null) {
                for (CarBasic item : carBasicList) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("value", item.getCar_Id());
                    jsonObject.put("name", item.getCar_Name());
                    data.add(jsonObject);
                }
            }

            map.put("status", 200);
            map.put("data", data);

        } catch (Exception e) {
            throw new RequestEmptyException("服务异常！");
        }

        return map;
    }

}
