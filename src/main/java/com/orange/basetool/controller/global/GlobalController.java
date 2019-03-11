package com.orange.basetool.controller.global;

import com.orange.basetool.service.primary.ILoginLogoutService;
import com.orange.basetool.service.primary.impl.LoginLogoutService;
import com.orange.basetool.service.test.impl.TestService;
import com.orange.basetool.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局页面操作
 */
@Controller
@RequestMapping("/")
public class GlobalController {

    private static final Logger log = LoggerFactory.getLogger(GlobalController.class);

    @Autowired
    private ILoginLogoutService loginLogoutService;

    @Autowired
    private TestService testService;

    /**
     * 登录页面
     * @param httpServletRequest request
     * @return page
     */
    @RequestMapping("/loginPage")
    public String loginPage(HttpServletRequest httpServletRequest){
        log.info("正在处理请求：" + httpServletRequest.getRequestURI());
        log.info(" httpServletRequest.getRemoteAddr()：" +  httpServletRequest.getRemoteAddr());
        log.info(" httpServletRequest.getRemoteUser()：" +  httpServletRequest.getRemoteUser());
        return "global/login";
    }

    /**
     * 用户登录校验
     * @param httpServletRequest request
     * @return page
     */
    @RequestMapping("/checkLogin")
    public String checkLogin(HttpServletRequest httpServletRequest){
        log.info("正在处理请求：" + httpServletRequest.getRequestURI());
        Map<String,Object> map = new HashMap<>();
        map.put("user_id","admin");
        JsonResult result = loginLogoutService.checkLogin(httpServletRequest);
        return "global/login";
    }

    /**
     * 登录后的主页面
     * @param httpServletRequest request
     * @return page
     */
    @RequestMapping("/homePage")
    public String homePage(HttpServletRequest httpServletRequest){
        log.info("正在处理请求：" + httpServletRequest.getRequestURI());
        return "global/home";
    }

}
