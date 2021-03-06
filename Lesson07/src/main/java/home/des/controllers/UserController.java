package home.des.controllers;

import home.des.domain.User;
import home.des.repository.UserDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public List<User> getAll(){
        return userDAO.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userDAO.findById(id).orElse(null);
    }
}
