package com.example.demo.controllers.admin;

import com.example.demo.models.Category;
import com.example.demo.models.User;
import com.example.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController implements IController<Category> {
    @Autowired CategoryService categoryService;

    @GetMapping("admin/category/list")
    @Override
    public String list(Model model, int page, int offset) {
        Page<Category> category = categoryService.getCategory(PageRequest.of(page - 1, offset));
        model.addAttribute("categories", category.getContent());
        Long totalRecord = categoryService.getTotal();
        Double totalPage = Math.ceil(totalRecord / offset);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("offset", offset);
        model.addAttribute("currentPage", page);
        return "backend/category/index";
    }

    @GetMapping("admin/category/add")
    @Override
    public String add(Model model) {
        return null;
    }

    @GetMapping("admin/category/edit")
    @Override
    public String edit(Model model, Long id) {
        return null;
    }

    @PostMapping("admin/category/do-add")
    @Override
    public String doAdd(Category gModel, RedirectAttributes attributes, MultipartFile file) {
        return null;
    }

    @PostMapping("admin/category/do-edit")
    @Override
    public String doEdit(Category gModel, Long id, String password) {
        return null;
    }

    @GetMapping("admin/category/delete")
    @Override
    public String delete(Long id) {
        return null;
    }
}
