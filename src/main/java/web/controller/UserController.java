package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.Service.UserService;
import web.models.User;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/all";
    }
    @GetMapping("/new")
    String newUser(Model model) {
        model.addAttribute("user", new User());
    return "pages/newUser";
    }
    @PostMapping("/")
    public String create(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/user";
    }
    void updateUser(User user) {

    }
    User readUser(long id) {
        return null;
    }
    void deleteUser(long id) {

    }
}
