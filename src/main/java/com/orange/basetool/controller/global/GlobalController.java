package com.orange.basetool.controller.global;

import com.orange.basetool.service.primary.ILoginLogoutService;
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
        log.info(result.toString());
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
        return "global/homePage";
    }

    /**
     * 错误页面400 Bad Request
     * @param httpServletRequest Bad Request
     * @return
     */
    @RequestMapping("/error-400")
    public String error400Page(HttpServletRequest httpServletRequest){
        log.info("正在处理请求：" + httpServletRequest.getRequestURI());
        return "global/error/400";
    }

    /**
     * 错误页面404 Not Found
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/error-404")
    public String error404Page(HttpServletRequest httpServletRequest){
        log.info("正在处理请求：" + httpServletRequest.getRequestURI());
        return "global/error/404";
    }

    /**
     * 错误页面500 Internal Server Error
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/error-500")
    public String error500Page(HttpServletRequest httpServletRequest){
        log.info("正在处理请求：" + httpServletRequest.getRequestURI());
        return "global/error/500";
    }

    /**
     * 其他错误
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/errorException")
    public String errorPage(HttpServletRequest httpServletRequest){
        log.info("正在处理请求：" + httpServletRequest.getRequestURI());
        return "global/error/error";
    }

}
