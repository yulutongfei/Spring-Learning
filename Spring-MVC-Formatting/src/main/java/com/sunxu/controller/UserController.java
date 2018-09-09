package com.sunxu.controller;

import com.sun.tracing.dtrace.Attributes;
import com.sunxu.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 孙许
 * @date 2018/09/09
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/handle81")
    public String handle81(@ModelAttribute("user") User user, ModelMap modelMap) {
        modelMap.put("user", user);
        return "/user/createSuccess";
    }

}
