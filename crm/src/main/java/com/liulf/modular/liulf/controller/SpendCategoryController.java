package com.liulf.modular.liulf.controller;

import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.RequestEmptyException;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liulf.core.common.annotion.Permission;
import com.liulf.core.common.exception.BizExceptionEnum;
import com.liulf.core.common.page.LayuiPageFactory;
import com.liulf.core.log.LogObjectHolder;
import com.liulf.core.shiro.ShiroKit;
import com.liulf.core.shiro.ShiroUser;
import com.liulf.core.util.BeanUtil;
import com.liulf.modular.liulf.entity.SpendCategory;
import com.liulf.modular.liulf.service.SpendCategoryService;
import com.liulf.modular.system.warpper.LogWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/spend_category")
public class SpendCategoryController extends CRMBaseController {
    private final static String PREFIX = "/modular/liulf/spend_category/";

    @Autowired
    SpendCategoryService spendCategoryService;

    @RequestMapping("/list")
    public String index() {
        return PREFIX + "list.html";
    }

    /**
     * 列表
     *
     * @Date 2018/12/23 5:34 PM
     */
    @RequestMapping("/listdata")
    @Permission
    @ResponseBody
    public Object listData(@Valid SpendCategory entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        }
        //获取分页参数
        Page page = LayuiPageFactory.defaultPage();
        try{
            long total = spendCategoryService.getPageCount(entity);
            page.setTotal(total);
            List<SpendCategory> listData = spendCategoryService.getPageList(page, entity);
            List<Map<String, Object>> result = BeanUtil.transBean2MapList(listData);
            page.setRecords(new LogWrapper(result).wrap());
        }catch (Exception e){
            log.error("spend_category/listdate -error",e);
        }
        return LayuiPageFactory.createPageInfo(page);
    }
    @RequestMapping("/view_add")
    public String addView() {
        return PREFIX + "add.html";
    }
    @RequestMapping(value = "/add")
    @Permission
    @ResponseBody
    public ResponseData add(@Valid SpendCategory entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }
        try{
            ShiroUser user = ShiroKit.getUser();
            entity.setUpdate_user(user.getId());
            entity.setCreate_user(user.getId());
            spendCategoryService.save(entity);
            return SUCCESS_TIP;
        }catch (Exception e){
            log.error("spend_category/add -error",e);
            throw new RequestEmptyException("服务异常！");
        }

    }

    @RequestMapping("/view_update")
    public String eidt(@RequestParam("spend_category_id") Long spend_category_id) {
        if (ToolUtil.isEmpty(spend_category_id)) {
            throw new RequestEmptyException();
        }
        SpendCategory entity = spendCategoryService.getById(spend_category_id);
        LogObjectHolder.me().set(entity);
        return PREFIX + "edit.html";
    }

    @RequestMapping(value = "/update")
    @Permission
    @ResponseBody
    public ResponseData update(@Valid SpendCategory entity , BindingResult result) {
        if (result.hasErrors()) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }
        try {
            ShiroUser user = ShiroKit.getUser();
            entity.setUpdate_user(user.getId());
            spendCategoryService.update(entity);
            return SUCCESS_TIP;
        } catch (Exception e) {
            log.error("spend_category/update -error", e);
            throw new RequestEmptyException("参数错误！");
        }
    }

    @RequestMapping(value = "/detail/{spend_category_id}")
    @Permission
    @ResponseBody
    public Object detail(@PathVariable("spend_category_id") Long spend_category_id) {
        SpendCategory entity = spendCategoryService.getById(spend_category_id);
        return entity;
    }


    @RequestMapping(value = "/delete")
    @Permission
    @ResponseBody
    public ResponseData delete(String ids) {
        ShiroUser user = ShiroKit.getUser();
        try{
            String[] arrIds = ids.split(",");
            List<Long> listIds = new ArrayList<>();
            for (String id : arrIds) {
                listIds.add(Long.parseLong(id));
            }
            spendCategoryService.deleteById(listIds, user.getId());
            return SUCCESS_TIP;
        }catch (Exception e){
            log.error("spend_category/delete -error",e);
            throw new RequestEmptyException("服务异常！");
        }
    }

    @RequestMapping("/select")
    @ResponseBody
    public Object select(String pid) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<SpendCategory> list = spendCategoryService.getAllList();

            List<JSONObject> data = new ArrayList<>();
            if (list != null) {
                for (SpendCategory item : list) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("value", item.getSpend_category_id());
                    jsonObject.put("name", item.getSpend_category_name());
                    data.add(jsonObject);
                }
            }

            map.put("status", 200);
            map.put("data", data);

        } catch (Exception e) {
            log.error("spend_category/select", e);
            throw new RequestEmptyException("服务异常！");
        }

        return map;
    }



}
