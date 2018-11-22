package com.lbb.clothes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @RequestMapping({"/", "/index"})
    public String index(HttpServletRequest request) {
        return "index";
    }
}
