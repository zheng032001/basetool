package com.orange.basetool.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.List;
import java.util.Map;

public class JsonUtil {

    /**
     * list转为json数据
     * @param list list
     * @return json数组
     */
    public static JSONArray list2Array(List<Map<String,Object>> list){
        return JSON.parseArray(JSON.toJSONString(list));
    }
}
