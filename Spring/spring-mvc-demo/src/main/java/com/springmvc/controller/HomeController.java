/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 11 Mar 2018
 **/

package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showPage() {
        return "index";
    }

    @RequestMapping("/showForm")
    public String showForm() {
        return "form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "processForm";
    }

    @RequestMapping("/processFormV2")
    public String processFormV2(HttpServletRequest httpServletRequest, Model model) {
        String name = httpServletRequest.getParameter("name");
        model.addAttribute("message", name.toUpperCase());
        return "processForm";
    }

}
