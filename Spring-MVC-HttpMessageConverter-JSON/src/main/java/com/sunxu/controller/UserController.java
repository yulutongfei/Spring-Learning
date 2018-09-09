package com.sunxu.controller;

import com.sunxu.domain.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping("/handle51")
    public ResponseEntity<User> handle51(HttpEntity<User> requestEntity) {
        User user = requestEntity.getBody();
        user.setUserId("1000");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
