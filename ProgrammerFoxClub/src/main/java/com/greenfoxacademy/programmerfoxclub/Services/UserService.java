package com.greenfoxacademy.programmerfoxclub.Services;

import com.greenfoxacademy.programmerfoxclub.Models.Fox;
import com.greenfoxacademy.programmerfoxclub.Models.User;
import com.greenfoxacademy.programmerfoxclub.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(String name, String password, String foxName) {
        Fox fox = new Fox(foxName);

        User user = new User(name,password,fox);

        userRepository.save(user);
    }

    //public Boolean userRegistered(String username, String password) {

    //}
}
