package com.liulf.modular.system.service;

import cn.hutool.core.bean.BeanUtil;
import com.liulf.core.common.constant.cache.Cache;
import com.liulf.core.util.CacheUtil;
import com.liulf.modular.system.entity.LoginLog;
import com.liulf.modular.system.mapper.LoginLogMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liulf.modular.system.model.LoginLogDto;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 登录记录 服务实现类
 * </p>
 *
 * @since 2018-12-07
 */
@Service
public class LoginLogService extends ServiceImpl<LoginLogMapper, LoginLog> {

    /**
     * 获取登录日志列表
     *
     * @Date 2018/12/23 5:53 PM
     */
    public List<Map<String, Object>> getLoginLogs(Page page, String beginTime, String endTime, String logName) {
        return this.baseMapper.getLoginLogs(page, beginTime, endTime, logName);
    }

    public void editLog(@Valid LoginLogDto loginLogDto) {

//        if (ToolUtil.isOneEmpty(roleDto, roleDto.getName(), roleDto.getPid(), roleDto.getDescription())) {
//            throw new RequestEmptyException();
//        }

        LoginLog old = this.getById(loginLogDto.getLoginLogId());
        BeanUtil.copyProperties(loginLogDto, old);
        this.updateById(old);

        //删除缓存
        CacheUtil.removeAll(Cache.CONSTANT);

    }
}
