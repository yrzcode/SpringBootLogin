package com.sample.springlogin.controller.indexpagecontroller;

import javax.validation.Valid;

import com.sample.springlogin.user.IUserAuthService;
import com.sample.springlogin.user.UserForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
public class UserAuthController {

    IUserAuthService userIdPasswordAuthService;

    @PostMapping("user")
    String postToAuthPage(
            @ModelAttribute("form")
            @Valid UserForm userForm,
            BindingResult result,
            Model model) {


        //test: see what are in model
        model.asMap().forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });


        //check input error
        var inputErrorList = result.getAllErrors();
        var isPassInputCheck = inputErrorList.size() == 0;
        if (!isPassInputCheck)
            model.addAttribute("inputCheckErrorList", inputErrorList);


        //check database authentication error
        var databaseAuthErrorList = userIdPasswordAuthService.getAuthErrorList(userForm);
        var isPassDatabaseAuthCheck = databaseAuthErrorList.size() == 0;
        if (!isPassDatabaseAuthCheck)
            model.addAttribute("message", databaseAuthErrorList.get(0));


        //final check
        var isPassAllCheck = isPassInputCheck
                          && isPassDatabaseAuthCheck;


        //decide which page to go by final check result
        return isPassAllCheck? "success" : "index";


    }

}