package com.orange.basetool.global.controller;

import com.orange.basetool.global.service.IUserService;
import com.orange.basetool.global.service.impl.UserService;
import com.orange.basetool.global.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户操作
 */
@Controller
@RequestMapping("/")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private IUserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     * 用户登录校验
     * @param httpServletRequest request
     * @return result
     */
    @RequestMapping("/checkLogin")
    @ResponseBody
    public JsonResult checkLogin(HttpServletRequest httpServletRequest){
        log.info("正在处理请求：" + httpServletRequest.getRequestURI());
        JsonResult result = userService.checkLogin(httpServletRequest);
//        result.setCode(500);
////        result.setMsg("错误信息");
        log.info(result.toString());
        return result;
    }

    /**
     * 修改密码
     * @param httpServletRequest request
     * @return result
     */
    @RequestMapping("/updatePassword")
    @ResponseBody
    public JsonResult updatePassword(HttpServletRequest httpServletRequest){
        log.info("正在处理请求：" + httpServletRequest.getRequestURI());
        return null;
    }

    /**
     * 用户列表页面--测试
     * @param httpServletRequest request
     * @return page
     */
    @RequestMapping("/userListPage")
    public String userListPage(HttpServletRequest httpServletRequest){
        log.info("正在处理请求：" + httpServletRequest.getRequestURI());
        return "global/userListPage";
    }

    /**
     * 获取用户列表--测试
     * @param httpServletRequest request
     * @return result
     */
    @RequestMapping("/getUserList")
    @ResponseBody
    public JsonResult getUserList(HttpServletRequest httpServletRequest){
        log.info("正在处理请求：" + httpServletRequest.getRequestURI());
        JsonResult result = userService.getUserList(httpServletRequest);
//        JSONObject json = new JSONObject();
//        json.put("status",0);
//        json.put("code",0);
//        Map<String,Object> map = (Map<String, Object>) result.getData();
//        json.put("total",map.get("total"));
//        json.put("data",map.get("data"));
//        System.out.println(json);
        System.out.println(result);
        return result;
    }

}
