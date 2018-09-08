package com.sunxu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
