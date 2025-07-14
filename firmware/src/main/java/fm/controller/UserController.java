package fm.controller;

import fm.model.User;
import fm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/firmware/user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public Flux<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{userId}")
    public Mono<User> getUserById(@PathVariable int userId) {

        return service.getUserById(userId);
    }

    @PostMapping
    public Mono<User> saveUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @DeleteMapping("/id")
    public Mono<Void> deleteUser(@PathVariable int id) {
        return service.deleteUserById(id);
    }
}
