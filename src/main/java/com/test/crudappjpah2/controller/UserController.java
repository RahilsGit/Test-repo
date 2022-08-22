package com.test.crudappjpah2.controller;

import com.test.crudappjpah2.entity.User;
import com.test.crudappjpah2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) //We'll get JSON user data, and we'll bind to Model class.
    {
        System.out.println("In controller");
        return userService.createUser(user);
    }

    @PostMapping("/addUsers")
    public List<User> addUser(@RequestBody List<User> users)
    {
        return userService.createUsers(users);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id)
    {
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers()
    {
        return userService.getUsers();
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user)
    {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id)
    {
        return userService.deleteUserById((id));
    }

    @GetMapping("/msg")
    public String messageTest()
    {
        return "Success";
    }






}
