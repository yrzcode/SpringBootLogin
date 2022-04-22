package com.sample.springlogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"index", "/"})
public class IndexPage {

    @GetMapping
    String getMappingIndex(){
        AuthPage.hasPassAuth = false;
        return "AuthPage";
    }

}
