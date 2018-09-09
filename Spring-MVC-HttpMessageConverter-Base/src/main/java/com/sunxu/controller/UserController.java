package com.sunxu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 孙许
 * @date 2018/09/09
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 将请求报文体转换为字符串绑定到requestBody入参中
     * @param requestBody
     * @return
     */
    @RequestMapping("/handle41")
    public String handle41(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return "/user/test1";
    }
}
