package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.models.User;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //показать всех _______________________________________________________________________________
    @GetMapping("/allUsers")
    String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/allUsers";
    }

    //создать нового _______________________________________________________________________________
    @GetMapping("/new")
    String newUser(Model model) {
        model.addAttribute("user", new User());
    return "/newUser";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/allUsers";
    }

    //прочитать по id _______________________________________________________________________________
//    @GetMapping("/{id}")
//    public String read(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userService.readUser(id));
//        return "/show";
//    }
//    void updateUser(User user) {
//
//    }

//    void deleteUser(long id) {
//
//    }
}
