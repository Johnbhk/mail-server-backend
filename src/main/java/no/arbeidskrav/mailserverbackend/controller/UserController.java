package no.arbeidskrav.mailserverbackend.controller;

import no.arbeidskrav.mailserverbackend.model.MyDTO;
import no.arbeidskrav.mailserverbackend.model.User;
import no.arbeidskrav.mailserverbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public String getUserByUsername(@PathVariable String username) {
        return UserService.getUserByUsername(username);
    }


    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{dto}")
    public List<MyDTO> getAllDTOs() {
        return userService.getAllDTOs();
    }

}

