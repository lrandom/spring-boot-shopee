package com.example.demo.controllers.admin;

import com.example.demo.helpers.Helpers;
import com.example.demo.models.GenericModel;
import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.misc.Request;
import sun.security.provider.MD5;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Controller
public class UserController implements IController<User> {

    @Autowired
    private UserService userService;

    @Value("${config.upload_folder}")
    String UPLOADED_FOLDER;

    @Override
    @GetMapping("admin/user/list")
    public String list(Model model, @RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "10") int offset) {
        Page<User> users = userService.getUsers(PageRequest.of(page - 1, offset));
        model.addAttribute("users", users.getContent());
        Long totalRecord = userService.getTotal();
        Double totalPage = Math.ceil(totalRecord / offset);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("offset", offset);
        model.addAttribute("currentPage", page);
        return "backend/user/index";
    }

    @Override
    @GetMapping("admin/user/add")
    public String add(Model model) {
        model.addAttribute("gModel", new User());
        return "backend/user/add";
    }

    @Override
    @GetMapping("admin/user/edit")
    public String edit(Model model, @RequestParam Long id) {
        User user = userService.getUser(id);
        model.addAttribute("gModel", user);
        return "backend/user/edit";
    }


    @Override
    @PostMapping("admin/user/do-add")
    public String doAdd(User gModel,
                        RedirectAttributes attributes
            , @RequestParam(name = "file") MultipartFile file) {
        User user = (User) gModel;
        user.setPassword(Helpers.getMd5(user.getPassword()));

        try {

            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year = localDate.getYear();
            int month = localDate.getMonthValue();

            String saveFolder = UPLOADED_FOLDER + month + "_" + year + "/";
            attributes.addFlashAttribute("message", "Done");///Users/mac/Documents/uploads/11_2020

            File dir = new File(saveFolder);
            if (dir.isFile() || !dir.exists()) {
                dir.mkdir(); //tạo mới một folder Users/mac/Documents/uploads/11_2020
            }

            String filename = System.currentTimeMillis() + file.getOriginalFilename();

            byte[] bytes = file.getBytes();
            Path path = Paths.get(dir.getAbsolutePath() + "/" + filename);
            Files.write(path, bytes);
            user.setAvatar(saveFolder.replace(UPLOADED_FOLDER, "")
                    + filename); //11_2020/tenfile.png
            userService.saveUser(user);
            attributes.addFlashAttribute("message", "Add user successfully");
        } catch (Exception e) {
            e.printStackTrace();
            attributes.addFlashAttribute("error", "Add failed " + e.getMessage());
        }
        return "redirect:/admin/user/add"; //chuyen ve form add
    }


    @Override
    @PostMapping("admin/user/do-edit")
    public String doEdit(User gModel,
                         @RequestParam Long id,
                         @RequestParam String password) {
        User user = (User) gModel;
        user.setPassword(Helpers.getMd5(password));
        userService.saveUser(user);
        return "redirect:/admin/user/edit?id=" + id;
    }

    @Override
    @GetMapping("admin/user/delete")
    public String delete(@RequestParam Long id) {
        User user = userService.getUser(id);
        try {
            File file = new File(UPLOADED_FOLDER + user.getAvatar());
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        userService.deleteUser(id);
        return "redirect:/admin/user/list";
    }
}
