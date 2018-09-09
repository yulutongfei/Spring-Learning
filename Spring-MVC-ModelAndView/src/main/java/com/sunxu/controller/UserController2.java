package com.sunxu.controller;

import com.sunxu.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author 孙许
 * @date 2018/09/09
 */
@Controller
@RequestMapping("/user2")
@SessionAttributes("user")
public class UserController2 {

    /**
     * 如果使用@SessionAttributes不加此方法会报错。详解见《精通Spring4.x》P590
     * @return
     */
    @ModelAttribute("user")
    public User getUser() {
        User user = new User();
        user.setUserId("1001");
        return user;
    }

    @RequestMapping("/handle65")
    public String handle65(@ModelAttribute("user") User user) {
        user.setUserName("John");
        // todo 请求重定向不成功
        return "redirect:/user2/handle66";
    }

    @RequestMapping("/handle66")
    public String handle66(ModelMap modelMap, SessionStatus sessionStatus) {
        User user = (User) modelMap.get("user");
        if (user != null) {
            user.setUserName("Jetty");
            sessionStatus.setComplete();
        }
        return "/user/createSuccess";
    }
}
