package com.sample.springlogin.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.springlogin.bean.user.UserForm;
import com.sample.springlogin.controller.auth.Auth;

@Controller
@RequestMapping({"index", "/"})
public class Index {

    @GetMapping
    String getMappingIndex(
            @ModelAttribute("form")
            UserForm userForm
    ){
        Auth.hasPassAuth  = false;
        return "AuthPage";
    }

}
