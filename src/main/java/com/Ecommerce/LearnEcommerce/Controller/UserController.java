package com.Ecommerce.LearnEcommerce.Controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.Ecommerce.LearnEcommerce.entity.UserEntity;
import com.Ecommerce.LearnEcommerce.exception.RessourceNotFoundException;
import com.Ecommerce.LearnEcommerce.model.User;
import com.Ecommerce.LearnEcommerce.repository.UserRepository;
import org.hibernate.usertype.UserTypeSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

//    @GetMapping
//    public String getUsers(){
//        return "Hello Api";
//    }

    @GetMapping
    public List<UserEntity> getUsers(){
//
//        return Arrays.asList(new User(1L,"john","john@gmail.com"),new User(2L,"joe","joe@gmail.com"),new User(3L,"Alice","Alice@gmail.com")) ;
        return userRepository.findAll();
    }
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user){
        return userRepository.save(user);


    }
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("User not found whith this id : " + id));
    }
    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id , @RequestBody UserEntity user){
        UserEntity userData=userRepository.findAllById(id).orElseThrow(()->new RessourceNotFoundException("User not found whith this id : " + id));
        userData.setEmail(user.getEmail());
        userData.setName(user.getName());
        return userRepository.save(userData);


    }
}
