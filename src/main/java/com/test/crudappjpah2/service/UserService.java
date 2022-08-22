package com.test.crudappjpah2.service;

import com.test.crudappjpah2.dao.UserRepository;
import com.test.crudappjpah2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user)
    {
        System.out.println("In service");
        return userRepository.save(user);
    }
    public List<User> createUsers(List<User> users)
    {
        return userRepository.saveAll(users);
    }

    public User getUserById(int id)
    {
        return userRepository.findById(id).orElse(null);
    }
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }
    public User updateUser(User user)
    {
        User oldUser=null; //Defined for method level access scope
        //User oldUser= userRepository.findById(user.getId()).orElse(null);
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if(optionalUser.isPresent())
        {
            oldUser= optionalUser.get();
            oldUser.setName(user.getName());
            oldUser.setAddress(user.getAddress());
            userRepository.save(oldUser);
        }
        else {
            return new User(); //returning empty user
        }
        return oldUser;
    }

    public String deleteUserById(int id)
    {
        userRepository.deleteById(id);
        return "User got deleted";
    }
}
