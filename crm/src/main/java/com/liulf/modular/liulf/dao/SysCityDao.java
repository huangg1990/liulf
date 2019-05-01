package com.liulf.modular.liulf.dao;

import com.liulf.init.SysCityDataLoadConfig;
import com.liulf.modular.liulf.entity.SysCity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SysCityDao extends BaseDao {

    public List<SysCity> getSysCityByLevelTypeAndPid(int levelType, int pid) {
        List<SysCity> list = SysCityDataLoadConfig.getAllCitiesList();

        log.info("getSysCityByLevelTypeAndPid  syscity list size {}", list.size());
        log.info("getSysCityByLevelTypeAndPid  levelType {} , pid {} ", levelType, pid);
        List<SysCity> resList = new ArrayList<>();
        for (SysCity sysCity : list) {
            if(sysCity==null){
                continue;
            }
            if (sysCity.getLevel_type() == levelType && sysCity.getPid() == pid) {
                resList.add(sysCity);
            }
        }
        return resList;
    }

    public List<SysCity> getSysCityListByIds(String... ids) {
        List<SysCity> list = SysCityDataLoadConfig.getAllCitiesList();

        List<SysCity> resList = new ArrayList<>();
        if (ids == null || ids.length == 0)
            return resList;
        for (String id : ids) {
            if (id == null) {
                continue;
            }
            list.forEach((city) -> {
                try{
                    if (city!=null && city.getId() == Integer.parseInt(id)) {
                        resList.add(city);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            });
        }
        return resList;
    }

//    private final static String getSysCityByLevelTypeAndPid_sql =
//            "select `id`,`city_name`,`pid`,`short_name`,`level_type`,`city_code`,`zip_code`,`merger_name`,`lng`,`lat`,`pin_yin`  from sys_city " +
//                    "where level_type=? and pid=?";
//
//    /**
//     * @param levelType
//     * @param pid
//     * @return
//     */
//    public List<SysCity> getSysCityByLevelTypeAndPid(int levelType, int pid) {
//        Object[] para = new Object[]{
//                levelType,
//                pid
//        };
//        List<SysCity> list = ybjJdbcTemplate.query(getSysCityByLevelTypeAndPid_sql, para, new BeanPropertyRowMapper(SysCity.class));
//        return list;
//    }
//
//    private final static String getSysCityListByIds =
//            "select `id`,`city_name`,`pid`,`short_name`,`level_type`,`city_code`,`zip_code`,`merger_name`,`lng`,`lat`,`pin_yin`  from sys_city " +
//                    "where `id` in ";
//
//    /**
//     * @param ids
//     * @return
//     */
//    public List<SysCity> getSysCityListByIds(String... ids) {
//        if (ids == null || ids.length == 0)
//            return null;
//        String cityIds = Joiner.on(",").join(ids);
//        String tempSql = getSysCityListByIds + "(" + cityIds + ");";
//        List<SysCity> list = ybjJdbcTemplate.query(tempSql, new BeanPropertyRowMapper(SysCity.class));
//        return list;
//    }
}
