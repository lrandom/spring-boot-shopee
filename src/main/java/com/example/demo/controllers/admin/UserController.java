package com.example.demo.controllers.admin;

import com.example.demo.helpers.Helpers;
import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.Request;
import sun.security.provider.MD5;

import java.util.List;

@Controller
public class UserController implements IController {
    @Autowired
    private UserService userService;


    @Override
    @GetMapping("admin/user/list")
    public String list(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "backend/user/index";
    }

    @Override
    @GetMapping("admin/user/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "backend/user/add";
    }

    @Override
    @GetMapping("admin/user/edit")
    public String edit(Model model, @RequestParam Long id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "backend/user/edit";
    }

    @Override
    @PostMapping("admin/user/do-add")
    public String doAdd(User user) {
        user.setPassword(Helpers.getMd5(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/admin/user/add"; //chuyen ve form add
    }

    @Override
    @PostMapping("admin/user/do-edit")
    public String doEdit(User user,
                         @RequestParam Long id,
                         @RequestParam String password) {
        user.setPassword(Helpers.getMd5(password));
        userService.saveUser(user);
        return "redirect:/admin/user/edit?id=" + id;
    }

    @Override
    @GetMapping("admin/user/delete")
    public String delete(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/user/list";
    }
}
