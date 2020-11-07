package com.example.demo.controllers.admin;

import org.springframework.ui.Model;

public interface IController {
    public String list(Model model);
    public String add(Model model);
    public void edit();
    public void doAdd();
    public void doEdit();
}
