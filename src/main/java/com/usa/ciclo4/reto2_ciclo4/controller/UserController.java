package com.usa.ciclo4.reto2_ciclo4.controller;

import com.usa.ciclo4.reto2_ciclo4.model.User;
import com.usa.ciclo4.reto2_ciclo4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author jonathan  romero
 */
@RestController
@RequestMapping("/api/user/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }



    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return userService.delete(id);
    }

    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.authenticateUser(email,password);
    }

    @GetMapping("/emailexist/{email}")
    public boolean emailExists (@PathVariable("email") String email){
        return userService.emailExists(email);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Optional<User> getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }

}
