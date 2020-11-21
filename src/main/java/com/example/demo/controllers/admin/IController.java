package com.example.demo.controllers.admin;

import com.example.demo.models.GenericModel;
import com.example.demo.models.User;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface IController<T extends GenericModel>{
    public String list(Model model, int page, int offset);
    public String add(Model model);
    public String edit(Model model,Long id);
    public String doAdd(T gModel,
                        RedirectAttributes attributes,
                        MultipartFile file);
    public String doEdit(T gModel,Long id, String password);
    public String delete(Long id);
}
