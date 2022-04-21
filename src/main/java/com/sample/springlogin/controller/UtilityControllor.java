package com.sample.springlogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class UtilityControllor {

    @GetMapping({"user","success"})
    String returnToIndexPage() {return "index";}

}
