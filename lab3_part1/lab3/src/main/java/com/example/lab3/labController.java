package com.example.lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class labController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("title", "Main page");
        return "home";
    }

    @GetMapping("page1")
    public String page1(Model model){
        return "page1";
    }

    @GetMapping("page2")
    public String page2(Model model){
        return "page2";
    }

    @GetMapping("page3")
    public String page3(Model model){
        return "page3";
    }

    @GetMapping("page4")
    public String page4(Model model){
        return "page4";
    }
}
