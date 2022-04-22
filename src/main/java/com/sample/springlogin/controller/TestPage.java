package com.sample.springlogin.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("test")
public class TestPage {
    @GetMapping
    String getMappingTest(){
        return "test";
    }

}
