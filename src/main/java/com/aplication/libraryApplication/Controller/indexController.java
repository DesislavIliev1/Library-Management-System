package com.aplication.libraryApplication.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class indexController {

    @GetMapping("/")
    public String listHome(){
        return "index";
    }
}
