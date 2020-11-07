package com.example.demo.controllers.admin;

import com.example.demo.models.User;
import org.springframework.ui.Model;

public interface IController {
    public String list(Model model);
    public String add(Model model);
    public String edit(Model model,Long id);
    public String doAdd(User user);
    public String doEdit(User user,Long id, String password);
}
