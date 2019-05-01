package com.liulf.init;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liulf.modular.liulf.entity.SysCity;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SysCityDataLoadConfig {
    private static List<SysCity> ALL_CITIES_LIST = null;

    public static final int ROOT_ID = 100000;
    //public static final String filejson = System.getProperty("user.home") + "/ybj/sys_city.json";

    private static void init() {

        if (ALL_CITIES_LIST == null || ALL_CITIES_LIST.size() == 0) {
            loadData();
        }
        //log.info("getSysCityByLevelTypeAndPid  syscity list size {}", list.size());

    }

    private static void loadData() {
        try {
            ALL_CITIES_LIST = new ArrayList();
            File sys_cityFile = ResourceUtils.getFile("classpath:data/sys_city.json"); //类路径
            //            File sys_cityFile = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "data/sys_city.json");
            //File sys_cityFile = new File(filejson);
            String cityJson = ReadFile(sys_cityFile.getPath());

            JSONObject jsonObject = JSON.parseObject(cityJson);

            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (JSONObject province : jsonArray.toJavaList(JSONObject.class)) {

                JSONArray cities = province.getJSONArray("citys");
                for (JSONObject city : cities.toJavaList(JSONObject.class)) {
                    SysCity tempCity = new SysCity();
                    tempCity.setId(Integer.parseInt(city.get("code") + ""));
                    tempCity.setPid(Integer.parseInt(city.get("parent") + ""));
                    tempCity.setLevel_type(2);
                    tempCity.setCity_name(city.get("name") + "");
                    ALL_CITIES_LIST.add(tempCity);

                    JSONArray areas = city.getJSONArray("areas");
                    for (JSONObject area : areas.toJavaList(JSONObject.class)) {
                        SysCity tempArea = new SysCity();
                        tempArea.setId(Integer.parseInt(area.get("code") + ""));
                        tempArea.setPid(Integer.parseInt(area.get("parent") + ""));
                        tempArea.setLevel_type(3);
                        tempArea.setCity_name(area.get("name") + "");
                        ALL_CITIES_LIST.add(tempArea);
                    }

                }
                SysCity tempProvince = new SysCity();
                tempProvince.setId(Integer.parseInt(province.get("code") + ""));
                tempProvince.setLevel_type(1);
                tempProvince.setCity_name(province.get("name") + "");
                tempProvince.setPid(ROOT_ID);
                ALL_CITIES_LIST.add(tempProvince);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String ReadFile(String Path) {
        BufferedReader reader = null;
        String laststr = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }

    public static List<SysCity> getAllCitiesList() {
        init();
        return ALL_CITIES_LIST;
    }

    /**
     * 根据父节点，获取下级的级联信息，根节点的ID是100000
     *
     * @param pid
     * @return
     */
    public static List<SysCity> getCitiesList(int pid) {
        List<SysCity> ret = new ArrayList<SysCity>();
        for (SysCity city : getAllCitiesList()) {
            if (city.getPid() == pid) {
                ret.add(city);
            }
        }
        return ret;
    }

    /**
     * 根据ID取得名字
     *
     * @param id
     * @return
     */
    public static String getCityName(int id) {
        for (SysCity city : getAllCitiesList()) {
            if (city.getId() == id) {
                return city.getCity_name();
            }
        }
        return "";
    }

    public static String getSimpleCityName(int id) {
        String cityName = getCityName(id);
        if (cityName.endsWith("市")) {
            return cityName.replaceAll("市$", "");
        }
        return cityName;
    }

}
