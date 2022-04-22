package com.sample.springlogin.controller;

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
@RequestMapping("AuthPage")
public class AuthPage {

    static boolean hasPassAuth;
    static String loginAccountId;

    IUserAuthService userIdPasswordAuthService;

    @GetMapping
    String getMappingAuth(
            @ModelAttribute("form")
            UserForm userForm
    ){
        userForm.setAccountId(loginAccountId);
        return hasPassAuth? "Success" : "AuthPage";
    }

    @PostMapping
    String postMappingAuth(
            Model model,
            @ModelAttribute("form")
            @Valid UserForm userForm,
            BindingResult result
            ) {

        //check & get input error
        var inputErrorList = result.getAllErrors();
        var isPassInputCheck = inputErrorList.size() == 0;
        if (!isPassInputCheck)
            model.addAttribute("inputCheckErrorList", inputErrorList);


        //check & get database authentication error
        var databaseAuthErrorList = userIdPasswordAuthService.getAuthErrorList(userForm);
        var isPassDatabaseAuthCheck = databaseAuthErrorList.size() == 0;
        if (!isPassDatabaseAuthCheck)
            model.addAttribute("message", databaseAuthErrorList.get(0));
        else
            loginAccountId = userForm.getAccountId();


        //final check
        var isPassAllCheck = isPassInputCheck
                          && isPassDatabaseAuthCheck;


        //memorize login result
        hasPassAuth = isPassAllCheck;


        //decide which page to go by result
        return isPassAllCheck? "success" : "AuthPage";

    }

}