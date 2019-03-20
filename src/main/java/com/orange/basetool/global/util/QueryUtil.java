package com.orange.basetool.global.util;

import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryUtil {

    /**
     * 返回带总数的结果集，pageHelper参数count为true时使用
     * @param list 数据
     * @return 结果
     */
    public static JsonResult buildResult(List<Map<String,Object>> list){
        Map<String,Object> map = new HashMap<>();
        PageInfo pageInfo = new PageInfo<>(list);
        map.put("data",JsonUtil.list2Array(list));
        map.put("total",pageInfo.getTotal());
        return new JsonResult(map);
    }

    /**
     * 构造查询参数，默认构造分页和排序参数
     * @param httpServletRequest 请求
     * @param keys  参数名
     * @return  参数集合
     */
    public static Map<String,Object> buildParam(HttpServletRequest httpServletRequest,String... keys){
        Map<String,Object> map = new HashMap<>();
        // 默认需要构造的参数
        String[] defaultKeys = {"pageSize","pageNum","sortBy"};
        // 构造默认参数，自动trim
        for(String key : defaultKeys){
            if(null != httpServletRequest.getParameter(key)&&!"".equals(httpServletRequest.getParameter(key).trim())){
                map.put(key,httpServletRequest.getParameter(key).trim());
            }
        }
        // 构造传入参数
        for(String key : keys){
            if(null != httpServletRequest.getParameter(key)&&!"".equals(httpServletRequest.getParameter(key))){
                map.put(key,httpServletRequest.getParameter(key));
            }
        }
        return map;
    }
}
