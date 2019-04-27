package com.liulf.crm.modular.crm.controller.crm;

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
import com.liulf.crm.modular.crm.controller.CRMBaseController;
import com.liulf.crm.modular.crm.entity.Customer;
import com.liulf.crm.modular.crm.entity.Manufacturer;
import com.liulf.crm.modular.crm.entity.SysCity;
import com.liulf.crm.modular.crm.service.CustomerService;
import com.liulf.crm.modular.crm.service.ManufacturerService;
import com.liulf.crm.modular.crm.service.SysCityService;
import com.liulf.crm.modular.system.warpper.LogWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.*;

import static com.liulf.crm.modular.crm.entity.SysCity.getCityName;

@Controller
@RequestMapping("/customer")
public class CustomerController extends CRMBaseController {
    private final static String PREFIX = "/modular/crm/customer/";

    @Autowired
    CustomerService customerService;

    @Autowired
    SysCityService sysCityService;

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
    public Object listData(@Valid Customer entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        }
        //获取分页参数
        Page page = LayuiPageFactory.defaultPage();
        try{
            long total = customerService.getPageCount(entity);
            page.setTotal(total);
            List<Customer> listData = customerService.getPageList(page, entity);

            setCityViewData(listData);

            List<Map<String, Object>> result = BeanUtil.transBean2MapList(listData);
            page.setRecords(new LogWrapper(result).wrap());
        }catch (Exception e){
            log.error("firstpage/listdate -error",e);
        }
        return LayuiPageFactory.createPageInfo(page);
    }

    private void setCityViewData(List<Customer> manufacturerList) {
        if (manufacturerList == null || manufacturerList.size() == 0)
            return;
        Set<String> cityIds = new HashSet<>();
        for (Customer item : manufacturerList) {
            cityIds.add(item.getProvince());
            cityIds.add(item.getCity());
            cityIds.add(item.getArea());
        }
        String[] ids = new String[cityIds.size()];
        cityIds.toArray(ids);
        List<SysCity> sysCities = sysCityService.getSysCityListByIds(ids);
        for (Customer item : manufacturerList) {
            item.setProvince(getCityName(sysCities, item.getProvince()));
            item.setArea(getCityName(sysCities, item.getArea()));
            item.setCity(getCityName(sysCities, item.getCity()));
        }
    }

    @RequestMapping("/view_add")
    public String addView() {
        return PREFIX + "add.html";
    }
    @RequestMapping(value = "/add")
    @Permission
    @ResponseBody
    public ResponseData add(@Valid Customer entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }
        try{
            ShiroUser user = ShiroKit.getUser();
            entity.setUpdate_user(user.getId());
            entity.setCreate_user(user.getId());
            customerService.save(entity);
            return SUCCESS_TIP;
        }catch (Exception e){
            log.error("firstpage/add -error",e);
            throw new RequestEmptyException("服务异常！");
        }

    }

    @RequestMapping("/view_update")
    public String eidt(@RequestParam("customer_id") Long customer_id) {
        if (ToolUtil.isEmpty(customer_id)) {
            throw new RequestEmptyException();
        }
        Customer entity = customerService.getById(customer_id);
        LogObjectHolder.me().set(entity);
        return PREFIX + "edit.html";
    }

    @RequestMapping(value = "/update")
    @Permission
    @ResponseBody
    public ResponseData update(@Valid Customer entity , BindingResult result) {
        if (result.hasErrors()) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }
        try {
            ShiroUser user = ShiroKit.getUser();
            entity.setUpdate_user(user.getId());
            customerService.update(entity);
            return SUCCESS_TIP;
        } catch (Exception e) {
            log.error("community/update -error", e);
            throw new RequestEmptyException("参数错误！");
        }
    }

    @RequestMapping(value = "/detail/{customer_id}")
    @Permission
    @ResponseBody
    public Object detail(@PathVariable("customer_id") Long customer_id) {
        Customer entity = customerService.getById(customer_id);
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
            customerService.deleteById(listIds, user.getId());
            return SUCCESS_TIP;
        }catch (Exception e){
            log.error("firstpage/delete -error",e);
            throw new RequestEmptyException("服务异常！");
        }
    }


}