package com.sample.springlogin.user;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ComponentScan()
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String login(Model model) {
        return "/index";
    }


    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String login(
            @RequestParam(value = "accountId") String accountId,
            @RequestParam(value = "password") String password,
            Model model
    ) {

        String url = null;
        String message = null;

        User user = userService.queryUser(accountId);
        if (user == null) {
            message = "不正なユーザIDです!";
            model.addAttribute("message", message);
            url = "/index";
        } else if (!password.equals(user.getPassword())) {
            message = "不正なユーザIDです!";
            model.addAttribute("message", message);
            url = "/index";
        } else {
            url = "/success";
        }

//        url = "/index";
//        model.addAttribute("message", accountId);

        return url;
    }

}