package fi.academy.drinkifyrestapi;


import fi.academy.drinkifyrestapi.classes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Kontrollerilla hallitaan pyyntöjä User-collectioniin.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired UserRepository userrepo;

    /**
     * Luo uuden käyttäjän ja tallentaa sen User-collectioniin.
     * @param newUser parametrina siis käyttäjän email ja salasana
     * @return palauttaa luodun käyttäjän
     */
    @PostMapping("")
    public User addUser(@RequestBody User newUser) {
        User user = new User(newUser.getEmail(), newUser.getPassword());
        userrepo.save(user);
        return user;
    }

    /**
     * Palauttaa kaikki käyttäjät
     * @return
     */
    @GetMapping("")
    public List<User> getAllUsers() {
        return userrepo.findAll();
    }

    /**
     * Hakee käyttäjää id:n perusteella. Tätä tarkoitus käyttää kun etsitään itemin omistajaa.
     * @param id käyttäjän id User-collectionissa
     * @return palauttaa Optional-userin, tähän kommenttia
     */
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        return userrepo.findById(id);

    }

    /**
     * Hakee käyttäjää emailin perusteella
     * @param email polkuriippuvuus siis emailin mukaan
     * @return Optional<User>
     */
    @GetMapping("/getbyemail/{email}")
    public Optional<User> getByEmail(@PathVariable String email) {
        return userrepo.findUserByEmail(email);


    }
}
