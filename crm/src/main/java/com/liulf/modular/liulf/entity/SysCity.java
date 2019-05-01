package com.liulf.modular.liulf.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *   `id` int(10) NOT NULL,
 *   `city_name` varchar(256) DEFAULT NULL,
 *   `pid` int(10) DEFAULT NULL,
 *   `short_name` varchar(256) DEFAULT NULL,
 *   `level_type` int(4) NOT NULL,
 *   `city_code` varchar(32) DEFAULT NULL,
 *   `zip_code` varchar(16) DEFAULT NULL,
 *   `merger_name` varchar(256) DEFAULT NULL,
 *   `lng` varchar(256) DEFAULT NULL,
 *   `lat` varchar(256) DEFAULT NULL,
 *   `pin_yin` varchar(256) DEFAULT NULL,
 */
@Data
public class SysCity implements Serializable {
    private Integer id;
    private String city_name;
    private Integer pid;
    private String short_name;
    private Integer level_type;
    private String city_code;
    private String zip_code;
    private String merger_name;
    private String lng;
    private String lat;
    private String pin_yin;

    /**
     * @param cityList
     * @param sysCityId
     * @return
     */
    public static String getCityName(List<SysCity> cityList, String sysCityId) {
        for (SysCity sysCity : cityList) {

            if (sysCityId.equals(sysCity.getId() + "")) {
                return sysCity.getCity_name();
            }
        }
        return "";
    }

}
