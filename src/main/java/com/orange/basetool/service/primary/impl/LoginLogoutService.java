package com.orange.basetool.service.primary.impl;

import com.orange.basetool.mapper.primary.LoginLogoutMapper;
import com.orange.basetool.service.primary.ILoginLogoutService;
import com.orange.basetool.util.JsonResult;
import com.orange.basetool.util.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class LoginLogoutService implements ILoginLogoutService {

    @Autowired
    private LoginLogoutMapper loginLogoutMapper;

    @Override
    public JsonResult checkLogin(HttpServletRequest httpServletRequest) {
//        PageHelper.startPage(1,2,false);
        Map<String,Object> param = QueryUtil.buildParam(httpServletRequest,"user_id");
        List<Map<String,Object>> resultList = loginLogoutMapper.checkLogin(param);
        return QueryUtil.buildResult(resultList);
    }




}
