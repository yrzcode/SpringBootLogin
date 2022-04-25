package com.sample.springlogin.controller.success;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("success")
public class SuccessPage {

    @GetMapping
    String getSuccessPage() {
        return "index";
    }

}
