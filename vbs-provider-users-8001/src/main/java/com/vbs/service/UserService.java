package com.vbs.service;

import com.vbs.model.User;
import com.vbs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public boolean saveUser(User user){
        userRepository.save(user);
        return  true;
    }

    public boolean deleteUserById(Long id){
        User user = userRepository.getById(id);
//        if(user == null){
//            return false;
//        }
        userRepository.delete(user);
        return true;
    }

    public boolean updateUser(User user){
//        if(userRepository.findById(user.getUserId()) == null){
//            return false;
//        }
        userRepository.save(user);
        return  true;
    }

    public List<User> listUser(){
        return userRepository.findAll();
    }
}
