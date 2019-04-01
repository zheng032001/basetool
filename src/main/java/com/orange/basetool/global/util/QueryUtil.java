package com.orange.basetool.global.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
        PageInfo pageInfo = new PageInfo<>(list);
        return new JsonResult(JsonUtil.list2Array(list), (int) pageInfo.getTotal());
    }

    /**
     * 构造查询参数，默认构造分页和排序参数
     * @param httpServletRequest 请求
     * @param countTotal 是否计算总数
     * @param keys  参数名
     * @return  参数集合
     */
    public static Map<String,Object> buildParam(HttpServletRequest httpServletRequest,boolean countTotal,String... keys){
        Map<String,Object> map = new HashMap<>();
        // 默认需要构造的参数
        String[] defaultKeys = {"page","limit","field","order"};
        // 构造默认参数，自动trim
        for(String key : defaultKeys){
            if(null != httpServletRequest.getParameter(key)&&!"".equals(httpServletRequest.getParameter(key).trim())){
                map.put(key,httpServletRequest.getParameter(key).trim());
            }
        }
        int pageSize = 0;
        int pageNum = -1;
        String orderBy = "" ;
        // 分页
        if(map.containsKey("page")){
            pageNum = Integer.parseInt(map.get("page").toString());
            pageSize = Integer.parseInt(map.get("limit").toString());
        }
        // 排序
        if(map.containsKey("field")){
           orderBy = map.get("field").toString()+" "+map.get("order");
        }
        PageHelper.startPage(pageNum,pageSize,countTotal);
        PageHelper.orderBy(orderBy);
        // 构造传入参数
        for(String key : keys){
            if(null != httpServletRequest.getParameter(key)&&!"".equals(httpServletRequest.getParameter(key))){
                map.put(key,httpServletRequest.getParameter(key));
            }
        }
        return map;
    }

    /**
     * 构造查询参数，默认构造分页和排序参数，默认count
     * @param httpServletRequest 请求
     * @param keys  参数名
     * @return  参数集合
     */
    public static Map<String,Object> buildParam(HttpServletRequest httpServletRequest,String... keys){
        return buildParam(httpServletRequest,true,keys);
    }

    /**
     * 构造查询参数，默认构造分页和排序参数，默认不count
     * @param httpServletRequest 请求
     * @param keys  参数名
     * @return  参数集合
     */
    public static Map<String,Object> buildParamWithoutCount(HttpServletRequest httpServletRequest,String... keys){
        return buildParam(httpServletRequest,false,keys);
    }
}
