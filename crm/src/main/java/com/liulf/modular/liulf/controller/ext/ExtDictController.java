package com.liulf.modular.liulf.controller.ext;

import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.RequestEmptyException;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liulf.modular.liulf.entity.NameValue;
import com.liulf.modular.liulf.service.ext.ExtDictService;
import com.liulf.modular.system.entity.Dict;
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
@RequestMapping("/extdict")
public class ExtDictController {
    private static final Logger log = LoggerFactory.getLogger(ExtDictController.class);
    @Autowired
    ExtDictService extDictService;

    @RequestMapping("/detail")
    @ResponseBody
    public Object getDict( String code  ) {
        Map<String, Object> map = new HashMap<>();

        if (ToolUtil.isEmpty(code)) {
            throw new RequestEmptyException("参数错误！");
        }
        try{
            Dict dict= extDictService.getDictByCode(code);
            JSONArray jsonArray= JSONObject.parseArray(dict.getDescription());
            map.put("status", 200);
            map.put("data", jsonArray);

        }catch (Exception e){
           log.error("/extdict/detail -error",e);
            throw new RequestEmptyException("服务异常");
        }
        return map;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Object getDictList( String pcode  ) {

        if (ToolUtil.isEmpty(pcode)) {
            throw new RequestEmptyException("参数错误！");
        }
        Map<String, Object> map = new HashMap<>();
        try{
            List<Dict> dictList= extDictService.getDictListByPCode(pcode);

            List<NameValue> data=NameValue.ListDict2ListNameValue(dictList);

            map.put("status", 200);
            map.put("data", data);
        }catch (Exception e){
            log.error("/extdict/list",e);
        }

        return map;
    }
}
