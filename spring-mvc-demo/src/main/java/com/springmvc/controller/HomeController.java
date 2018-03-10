 /**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 11 Mar 2018
 **/

 package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showPage() {
        return "index";
    }

}
