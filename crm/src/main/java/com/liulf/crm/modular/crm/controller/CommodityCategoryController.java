package com.liulf.crm.modular.crm.controller;

import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.RequestEmptyException;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liulf.crm.core.common.annotion.Permission;
import com.liulf.crm.core.common.constant.Const;
import com.liulf.crm.core.common.exception.BizExceptionEnum;
import com.liulf.crm.core.common.page.LayuiPageFactory;
import com.liulf.crm.core.log.LogObjectHolder;
import com.liulf.crm.core.shiro.ShiroKit;
import com.liulf.crm.core.shiro.ShiroUser;
import com.liulf.crm.core.util.BeanUtil;
import com.liulf.crm.modular.crm.entity.CommodityCategory;
import com.liulf.crm.modular.crm.service.CommodityCategoryService;
import com.liulf.crm.modular.system.warpper.LogWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/commodity_category")
public class CommodityCategoryController extends CRMBaseController {
    private final static String PREFIX = "/modular/crm/commodity_category/";

    @Autowired
    CommodityCategoryService commodityCategoryService;

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
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Object listData(@Valid CommodityCategory entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        }
        //获取分页参数
        Page page = LayuiPageFactory.defaultPage();
        try{
            long total = commodityCategoryService.getPageCount(entity);
            page.setTotal(total);
            List<CommodityCategory> listData = commodityCategoryService.getPageList(page, entity);
            List<Map<String, Object>> result = BeanUtil.transBean2MapList(listData);
            page.setRecords(new LogWrapper(result).wrap());
        }catch (Exception e){
            log.error("firstpage/listdate -error",e);
        }
        return LayuiPageFactory.createPageInfo(page);
    }
    @RequestMapping("/view_add")
    public String addView() {
        return PREFIX + "add.html";
    }
    @RequestMapping(value = "/add")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public ResponseData add(@Valid CommodityCategory entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }
        try{
            ShiroUser user = ShiroKit.getUser();
            entity.setUpdate_user(user.getId());
            entity.setCreate_user(user.getId());
            commodityCategoryService.save(entity);
            return SUCCESS_TIP;
        }catch (Exception e){
            log.error("firstpage/add -error",e);
            throw new RequestEmptyException("服务异常！");
        }

    }

    @Permission
    @RequestMapping("/edit")
    public String eidt(@RequestParam("category_id") Long category_id) {
        if (ToolUtil.isEmpty(category_id)) {
            throw new RequestEmptyException();
        }
        CommodityCategory entity = commodityCategoryService.getById(category_id);
        LogObjectHolder.me().set(entity);
        return PREFIX + "edit.html";
    }

    @RequestMapping(value = "/update")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public ResponseData update(@Valid CommodityCategory entity , BindingResult result) {
        if (result.hasErrors()) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }
        try {
            ShiroUser user = ShiroKit.getUser();
            entity.setUpdate_user(user.getId());
            commodityCategoryService.update(entity);
            return SUCCESS_TIP;
        } catch (Exception e) {
            log.error("community/update -error", e);
            throw new RequestEmptyException("参数错误！");
        }
    }

    @RequestMapping(value = "/detail/{category_id}")
    @Permission
    @ResponseBody
    public Object detail(@PathVariable("category_id") Long category_id) {
        CommodityCategory entity = commodityCategoryService.getById(category_id);
        return entity;
    }


    @RequestMapping(value = "/delete")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public ResponseData delete(String ids) {
        ShiroUser user = ShiroKit.getUser();
        try{
            String[] arrIds = ids.split(",");
            List<Long> listIds = new ArrayList<>();
            for (String id : arrIds) {
                listIds.add(Long.parseLong(id));
            }
            commodityCategoryService.deleteById(listIds, user.getId());
            return SUCCESS_TIP;
        }catch (Exception e){
            log.error("firstpage/delete -error",e);
            throw new RequestEmptyException("服务异常！");
        }
    }


}
