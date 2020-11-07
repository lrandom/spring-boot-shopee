package com.example.demo.controllers.admin;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController implements IController{
    @Autowired private UserService userService;


    @Override
    @GetMapping("admin/user/list")
    public String list(Model model) {
        List<User> users= userService.getUsers();
        model.addAttribute("users",users);
        return "backend/user/index";
    }

    @Override
    @GetMapping("admin/user/add")
    public String add(Model model) {
        return "backend/user/add";
    }

    @Override
    public void edit() {

    }

    @Override
    public void doAdd() {

    }

    @Override
    public void doEdit() {

    }
}
