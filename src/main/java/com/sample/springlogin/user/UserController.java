package com.sample.springlogin.user;

import javax.validation.Valid;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("index")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private UserService userService;

//    @GetMapping("index")
////    @RequestMapping(value = "index", method = RequestMethod.GET)
//    public String auth() {
//        return "index";
//    }
//
//    @GetMapping("auth")
////    @RequestMapping(value = "auth", method = RequestMethod.GET)
//    public String home() {
//        return "index";
//    }

    @GetMapping({"auth","index"})
//    @RequestMapping(value = "auth", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @PostMapping("auth")
//    @RequestMapping(value = "auth", method = RequestMethod.POST)
    public String auth(
            @ModelAttribute("form")
            //@ModelAttribute
            @Valid UserForm userForm,
            BindingResult result,
            Model model)
    {

        String url = null;

        if (result.hasErrors()) {
            List<ObjectError> inputCheckErrorList = result.getAllErrors();
            model.addAttribute("inputCheckErrorList", inputCheckErrorList);
            url = "index";
        }

        List<String> dataBaseErrorList = userService.getResult(userForm);
        if (!(dataBaseErrorList.size() == 0)) {
            model.addAttribute("message", dataBaseErrorList.get(0));
            url = "index";
        } else {
            url = "success";
        }

        return url;
    }


    //@PostMapping()
//    @RequestMapping(method = RequestMethod.POST)
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
//
//        if (user == null) {
//            message = "不正なユーザIDです!";
//            model.addAttribute("message", message);
//            url = "/index";
//        } else if (!password.equals(user.getPassword())) {
//            message = "不正なユーザIDです!";
//            model.addAttribute("message", message);
//            url = "/index";
//        } else {
//            url = "success";
//        }
//
//        return url;
//    }

}