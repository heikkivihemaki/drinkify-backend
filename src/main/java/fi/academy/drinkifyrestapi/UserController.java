package fi.academy.drinkifyrestapi;


import fi.academy.drinkifyrestapi.classes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired UserRepository userrepo;

    @PostMapping("")
    public User addUser(@RequestBody User newUser) {
        User user = new User(newUser.getEmail(), newUser.getPassword());
        userrepo.save(user);
        return user;
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        return userrepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        return userrepo.findById(id);

    }

    @GetMapping("/getbyemail/{email}")
    public Optional<User> getByEmail(@PathVariable String email) {
        return userrepo.findUserByEmail(email);


    }
}
