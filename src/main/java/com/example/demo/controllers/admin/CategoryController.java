package com.example.demo.controllers.admin;

import com.example.demo.helpers.Helpers;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.List;

@Controller
public class CategoryController implements IController<Category> {
    @Autowired
    CategoryService categoryService;

    @GetMapping("admin/category/list")
    @Override
    public String list(Model model, @RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "10") int offset) {
        Page<Category> category = categoryService
                .getCategory(PageRequest.of(page - 1, offset));
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
        List<Category> listParentCategory = categoryService.getCategory();
        model.addAttribute("parents", listParentCategory);
        model.addAttribute("gModel", new Category());
        return "backend/category/add";
    }

    @GetMapping("admin/category/edit")
    @Override
    public String edit(Model model, Long id) {
        List<Category> listParentCategory = categoryService
                .getCategories(id);
        model.addAttribute("parents", listParentCategory);
        Category category = categoryService.getCategory(id);
        model.addAttribute("gModel", category);
        return "backend/category/edit";
    }

    @PostMapping("admin/category/do-add")
    @Override
    public String doAdd(Category gModel,
                        RedirectAttributes attributes,
                        MultipartFile file) {
        try {
            categoryService.saveCategory(gModel);
            attributes.addFlashAttribute("message", "Add user successfully");
        } catch (Exception e) {
            attributes.addFlashAttribute("error", "Add failed " + e.getMessage());
        }
        return "redirect:/admin/category/add"; //chuyen ve form add
    }

    @PostMapping("admin/category/do-edit")
    @Override
    public String doEdit(Category gModel, Long id,
                         RedirectAttributes attributes,
                         String password) {
        Category category = (Category) gModel;
        try {
            categoryService.saveCategory(category);
            attributes.addFlashAttribute("message", "Add user successfully");
        }catch (Exception e){
            attributes.addFlashAttribute("error", "Add failed " + e.getMessage());
        }

        return "redirect:/admin/category/edit?id=" + id;
    }

    @GetMapping("admin/category/delete")
    @Override
    public String delete(Long id) {
        Category category = categoryService.getCategory(id);
        categoryService.deleteCategory(id);
        return "redirect:/admin/category/list";
    }
}
