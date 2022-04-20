package com.sample.springlogin.user;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@ComponentScan()
@RequestMapping("index")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
//    @GetMapping("index")
    public String login(@ModelAttribute("form") UserForm userForm, Model model) {
        return "/index";
    }

    @RequestMapping(method = RequestMethod.POST)
//    @GetMapping("index")
    public String auth(@ModelAttribute("form") @Valid UserForm userForm, BindingResult result, Model model){

        String url = null;

        if (result.hasErrors()) {
            List<ObjectError> inputCheckErrorList = result.getAllErrors();
            model.addAttribute("inputCheckErrorList", inputCheckErrorList);
            url = "/index";
        }

        List<String> dataBaseErrorList = userService.getResult(userForm);
        if (!(dataBaseErrorList.size() == 0)) {
            model.addAttribute("message", dataBaseErrorList.get(0));
            url = "/index";
        } else {
            url = "/success";
        }

        return url;
    }


//    @RequestMapping(value = "/auth", method = RequestMethod.POST)
//    public String login(
//            @RequestParam(value = "accountId") String accountId,
//            @RequestParam(value = "password") String password,
//            Model model
//    ) {
//
//        String url = null;
//        String message = null;
//
//        User user = userService.queryUser(accountId);
//        if (user == null) {
//            message = "不正なユーザIDです!";
//            model.addAttribute("message", message);
//            url = "/index";
//        } else if (!password.equals(user.getPassword())) {
//            message = "不正なユーザIDです!";
//            model.addAttribute("message", message);
//            url = "/index";
//        } else {
//            url = "/success";
//        }
//
//        return url;
//    }

}