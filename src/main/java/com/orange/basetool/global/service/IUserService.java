package com.orange.basetool.global.service;

import com.orange.basetool.global.util.JsonResult;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {

    JsonResult checkLogin(HttpServletRequest httpServletRequest);

    JsonResult getUserList(HttpServletRequest httpServletRequest);
}
