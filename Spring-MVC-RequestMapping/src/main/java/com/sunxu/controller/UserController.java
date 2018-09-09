package com.sunxu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 孙许
 * @date 2018/09/08
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/register")
    public String register() {
        return "/user/register";
    }

    @RequestMapping("/createUser/{userId}")
    public String createUser(@PathVariable("userId") String userId) {
        System.out.println(userId);
        return "/user/createUser";
    }

    @RequestMapping(value = "/test1", method = RequestMethod.POST, params = "userId")
    public String test1(@RequestParam("userId") String userId) {
        System.out.println(userId);
        return "/user/test1";
    }

    @RequestMapping(value = "/test2", method = RequestMethod.POST, headers = "content-type=text/*")
    public String test2(@RequestParam("userId") String userId) {
        System.out.println(userId);
        return "/user/test1";
    }

    @RequestMapping("/test3")
    public String test3(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        @RequestParam("realName") String realName) {
        System.out.println("userName: " + userName);
        System.out.println("password: " + password);
        System.out.println("realName: " + realName);
        return "/user/test1";
    }

    @RequestMapping("/test4")
    public ModelAndView test4(@CookieValue("JSESSIONID") String sessionId,
                              @RequestHeader("Accept-Language") String acceptLanguage) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/user/test1");
        mav.addObject("string", "sunxu");
        return mav;
    }

    @RequestMapping("/test5")
    public void test5(HttpServletRequest request) {
        String name = request.getParameter("name");
        System.out.println(name);
    }

    @RequestMapping("/test6")
    public void test6(HttpSession session) {
        String name = (String) session.getAttribute("name");
        System.out.println(name);
    }
}
