package com.example.demo.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("admin/dashboard")
    public String index(){
        return "backend/layout";
    }
}
