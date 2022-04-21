package com.sample.springlogin.user;

import javax.validation.Valid;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private IUserService userService;

    @GetMapping("user")
    public String getToIndexPage() {
        return "index";
    }

    @PostMapping("user")
    public String postToAuthPage(
            @ModelAttribute("form")
            @Valid UserForm userForm,
            BindingResult result,
            Model model) {


        //check input error
        var inputErrorList = result.getAllErrors();
        var isPassInputCheck = inputErrorList.size() == 0;
        if (!isPassInputCheck)
            model.addAttribute("inputCheckErrorList", inputErrorList);


        //check database authentication error
        var databaseAuthErrorList = userService.getAuthErrorList(userForm);
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