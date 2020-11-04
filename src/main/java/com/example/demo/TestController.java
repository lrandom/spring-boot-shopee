package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
    @GetMapping("/admin")
    public String index(Model model) {
        model.addAttribute("name","Nguyễn Thành Luân");
        //return "index";
        return "layout";
    }

    @RequestMapping(path = "/members", method = RequestMethod.GET)
    public String index2(){
        return "index";
    }
}
