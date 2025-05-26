package com.example.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AboutController {


    public AboutController() {}

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
