package home.des.controllers;

import home.des.domain.Role;
import home.des.domain.User;
import home.des.repository.UserDAO;
import home.des.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String usersList(Model model) {
        model.addAttribute("users", userService.getAll());
        return "userList";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable Long id) {
        User user = userService.getById(id);
        model.addAttribute("user", user == null ? new User() : user);
        return "user";
    }

    @PostMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }

    @PostMapping("/updateUser")
    public String updateUser(User userForm) {
        userService.save(userForm);
        return "redirect:/users";
    }
}
