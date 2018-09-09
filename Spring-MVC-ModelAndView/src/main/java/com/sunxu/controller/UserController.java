package com.sunxu.controller;

import com.sunxu.domain.Address;
import com.sunxu.domain.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
     * 在访问UserController中的任何一个请求处理方法之前，都会事先执行标注了@ModelAttribute
     * 的getUser方法，并将其返回值以user为键添加到模型中。
     * @return
     */
    @ModelAttribute("user")
    public User getUser() {
        User user = new User();
        user.setUserId("1001");
        return user;
    }

    @ModelAttribute("address")
    public Address getAddress() {
        Address address = new Address();
        address.setProvince("AnHui");
        return address;
    }

    @RequestMapping("/handle61")
    public String handle61(@ModelAttribute("user") User user) {
        user.setUserId("1000");
        return "/user/createSuccess";
    }

    /**
     * 方法使用了入参级的@ModelAttribute注解，且属性名与方法级@ModelAttribute的属性名相同。
     * SpringMVC会将getUser方法返回的模型属性赋值给入参的user
     * @param user
     * @return
     */
    @RequestMapping("/handle62")
    public String handle62(@ModelAttribute("user") User user) {
        user.setUserName("tom");
        return "/user/createSuccess";
    }

    @RequestMapping("/handle63")
    public String handle63(@ModelAttribute("user") User user, @ModelAttribute("address") Address address) {
        user.setUserName("tom");
        address.setCity("HangZhou");
        return "/user/createSuccess";
    }

    /**
     * SpringMVC在调用方法前会创建一个隐含的模型对象，作为模型数据的存储容器。
     * 会将user和address自动存入其中
     * @param modelMap
     * @return
     */
    @RequestMapping("/handle64")
    public String handle64(ModelMap modelMap) {
        modelMap.addAttribute("testAttr", "value1");
        User user = (User) modelMap.get("user");
        user.setPassword("123");
        return "/user/createSuccess";
    }

}
