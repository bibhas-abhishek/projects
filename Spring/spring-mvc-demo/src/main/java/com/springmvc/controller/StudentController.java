package com.springmvc.controller;

import com.springmvc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.RequestWrapper;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        return "student-confirmation";
    }

}
