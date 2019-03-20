package com.orange.basetool.global.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局页面操作
 */
@Controller
@RequestMapping("/")
public class GlobalController {

    private static final Logger log = LoggerFactory.getLogger(GlobalController.class);

    /**
     * 登录页面
     * @param httpServletRequest request
     * @return page
     */
    @RequestMapping("/loginPage")
    public String loginPage(HttpServletRequest httpServletRequest){
        log.info("正在处理请求：" + httpServletRequest.getRequestURI());
//        log.info(" httpServletRequest.getRemoteAddr()：" +  httpServletRequest.getRemoteAddr());
//        log.info(" httpServletRequest.getRemoteUser()：" +  httpServletRequest.getRemoteUser());
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
     * @return page
     */
    @RequestMapping("/error-400")
    public String error400Page(HttpServletRequest httpServletRequest){
        log.info("正在处理请求：" + httpServletRequest.getRequestURI());
        return "global/error/400";
    }

    /**
     * 错误页面404 Not Found
     * @param httpServletRequest request
     * @return page
     */
    @RequestMapping("/error-404")
    public String error404Page(HttpServletRequest httpServletRequest){
        log.info("正在处理请求：" + httpServletRequest.getRequestURI());
        return "global/error/404";
    }

    /**
     * 错误页面500 Internal Server Error
     * @param httpServletRequest request
     * @return page
     */
    @RequestMapping("/error-500")
    public String error500Page(HttpServletRequest httpServletRequest){
        log.info("正在处理请求：" + httpServletRequest.getRequestURI());
        return "global/error/500";
    }

    /**
     * 其他错误
     * @param httpServletRequest request
     * @return page
     */
    @RequestMapping("/errorException")
    public String errorPage(HttpServletRequest httpServletRequest){
        log.info("正在处理请求：" + httpServletRequest.getRequestURI());
        return "global/error/error";
    }

}
