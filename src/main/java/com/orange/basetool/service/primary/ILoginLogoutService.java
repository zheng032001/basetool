package com.orange.basetool.service.primary;

import com.orange.basetool.util.JsonResult;

import javax.servlet.http.HttpServletRequest;

public interface ILoginLogoutService {

    JsonResult checkLogin(HttpServletRequest httpServletRequest);
}
