package com.liulf.modular.liulf.controller;

import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.RequestEmptyException;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liulf.core.common.annotion.Permission;
import com.liulf.core.common.exception.BizExceptionEnum;
import com.liulf.core.common.page.LayuiPageFactory;
import com.liulf.core.log.LogObjectHolder;
import com.liulf.core.shiro.ShiroKit;
import com.liulf.core.shiro.ShiroUser;
import com.liulf.core.util.BeanUtil;
import com.liulf.modular.liulf.entity.CommoditySell;
import com.liulf.modular.liulf.service.CommoditySellService;
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
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/commodity_sell")
public class CommoditySellController extends CRMBaseController {
    private final static String PREFIX = "/modular/liulf/commodity_sell/";

    @Autowired
    CommoditySellService CommoditySellService;

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
    public Object listData(@Valid CommoditySell entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        }
        //获取分页参数
        Page page = LayuiPageFactory.defaultPage();
        try{
            long total = CommoditySellService.getPageCount(entity);
            page.setTotal(total);
            List<CommoditySell> listData = CommoditySellService.getPageList(page, entity);
            List<Map<String, Object>> result = BeanUtil.transBean2MapList(listData);
            page.setRecords(new LogWrapper(result).wrap());
        }catch (Exception e){
            log.error("CommoditySell/listdate -error",e);
        }
        return LayuiPageFactory.createPageInfo(page);
    }
    @RequestMapping("/view_add")
    public String addView(String customer_id) {
        return PREFIX + "add.html";
    }
    @RequestMapping(value = "/add")
    @Permission
    @ResponseBody
    public ResponseData add(@Valid CommoditySell entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }
        try{
            ShiroUser user = ShiroKit.getUser();
            entity.setUpdate_user(user.getId());
            entity.setCreate_user(user.getId());
            CommoditySellService.save(entity);
            return SUCCESS_TIP;
        }catch (Exception e){
            log.error("CommoditySell/add -error",e);
            throw new RequestEmptyException("服务异常！");
        }

    }

    @RequestMapping("/view_update")
    public String eidt(@RequestParam("sell_id") Long sell_id) {
        if (ToolUtil.isEmpty(sell_id)) {
            throw new RequestEmptyException();
        }
        CommoditySell entity = CommoditySellService.getById(sell_id);
        LogObjectHolder.me().set(entity);
        return PREFIX + "edit.html";
    }

    @RequestMapping(value = "/update")
    @Permission
    @ResponseBody
    public ResponseData update(@Valid CommoditySell entity , BindingResult result) {
        if (result.hasErrors()) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }
        try {
            ShiroUser user = ShiroKit.getUser();
            entity.setUpdate_user(user.getId());
            CommoditySellService.update(entity);
            return SUCCESS_TIP;
        } catch (Exception e) {
            log.error("CommoditySell/update -error", e);
            throw new RequestEmptyException("参数错误！");
        }
    }

    @RequestMapping(value = "/detail/{sell_id}")
    @Permission
    @ResponseBody
    public Object detail(@PathVariable("sell_id") Long sell_id) {
        CommoditySell entity = CommoditySellService.getById(sell_id);
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
            CommoditySellService.deleteById(listIds, user.getId());
            return SUCCESS_TIP;
        }catch (Exception e){
            log.error("CommoditySell/delete -error",e);
            throw new RequestEmptyException("服务异常！");
        }
    }



}
