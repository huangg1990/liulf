package com.liulf.crm.modular.crm.controller;

import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.RequestEmptyException;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liulf.crm.core.common.annotion.Permission;
import com.liulf.crm.core.common.exception.BizExceptionEnum;
import com.liulf.crm.core.common.page.LayuiPageFactory;
import com.liulf.crm.core.log.LogObjectHolder;
import com.liulf.crm.core.shiro.ShiroKit;
import com.liulf.crm.core.shiro.ShiroUser;
import com.liulf.crm.core.util.BeanUtil;
import com.liulf.crm.modular.crm.entity.Spend;
import com.liulf.crm.modular.crm.service.SpendService;
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
@RequestMapping("/spend")
public class SpendController extends CRMBaseController {
    private final static String PREFIX = "/modular/crm/spend/";

    @Autowired
    SpendService SpendService;

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
    public Object listData(@Valid Spend entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        }
        //获取分页参数
        Page page = LayuiPageFactory.defaultPage();
        try{
            long total = SpendService.getPageCount(entity);
            page.setTotal(total);
            List<Spend> listData = SpendService.getPageList(page, entity);
            List<Map<String, Object>> result = BeanUtil.transBean2MapList(listData);
            page.setRecords(new LogWrapper(result).wrap());
        }catch (Exception e){
            log.error("spend/listdate -error",e);
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
    public ResponseData add(@Valid Spend entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }
        try{
            ShiroUser user = ShiroKit.getUser();
            entity.setUpdate_user(user.getId());
            entity.setCreate_user(user.getId());
            SpendService.save(entity);
            return SUCCESS_TIP;
        }catch (Exception e){
            log.error("spend/add -error",e);
            throw new RequestEmptyException("服务异常！");
        }

    }

    @RequestMapping("/view_update")
    public String eidt(@RequestParam("spend_id") Long spend_id) {
        if (ToolUtil.isEmpty(spend_id)) {
            throw new RequestEmptyException();
        }
        Spend entity = SpendService.getById(spend_id);
        LogObjectHolder.me().set(entity);
        return PREFIX + "edit.html";
    }

    @RequestMapping(value = "/update")
    @Permission
    @ResponseBody
    public ResponseData update(@Valid Spend entity , BindingResult result) {
        if (result.hasErrors()) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }
        try {
            ShiroUser user = ShiroKit.getUser();
            entity.setUpdate_user(user.getId());
            SpendService.update(entity);
            return SUCCESS_TIP;
        } catch (Exception e) {
            log.error("spend/update -error", e);
            throw new RequestEmptyException("参数错误！");
        }
    }

    @RequestMapping(value = "/detail/{spend_id}")
    @Permission
    @ResponseBody
    public Object detail(@PathVariable("spend_id") Long spend_id) {
        Spend entity = SpendService.getById(spend_id);
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
            SpendService.deleteById(listIds, user.getId());
            return SUCCESS_TIP;
        }catch (Exception e){
            log.error("spend/delete -error",e);
            throw new RequestEmptyException("服务异常！");
        }
    }



}
