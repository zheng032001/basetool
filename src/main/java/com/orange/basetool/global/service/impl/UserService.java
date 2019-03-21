package com.orange.basetool.global.service.impl;

import com.github.pagehelper.PageHelper;
import com.orange.basetool.global.mapper.UserMapper;
import com.orange.basetool.global.service.IUserService;
import com.orange.basetool.global.util.JsonResult;
import com.orange.basetool.global.util.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserService {

    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public JsonResult checkLogin(HttpServletRequest httpServletRequest) {
        Map<String,Object> param = QueryUtil.buildParamWithoutCount(httpServletRequest,"userId");
        List<Map<String,Object>> resultList = userMapper.checkLogin(param);
        return QueryUtil.buildResult(resultList);
    }




}
