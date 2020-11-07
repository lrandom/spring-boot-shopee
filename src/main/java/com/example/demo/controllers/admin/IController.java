package com.example.demo.controllers.admin;

import org.springframework.ui.Model;

public interface IController {
    public String list(Model model);
    public void add();
    public void edit();
    public void doAdd();
    public void doEdit();
}
