package com.atwangxin.springboot.controller;

import com.atwangxin.springboot.entity.User;
import com.atwangxin.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/use/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = new User();
        user.setId(id);
        Example<User> example = Example.of(user);
        Optional<User> one = userRepository.findOne(example);
        return one.get();
    }

    @GetMapping("/use")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }
}
