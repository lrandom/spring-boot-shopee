package com.example.demo.services;

import com.example.demo.jpamysql.UserJpa;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired private UserJpa userJpa;

    public List<User> getUsers(){
        return (List<User>)userJpa.findAll();
    }

    public void saveUser(User user){
        userJpa.save(user);
    }

    public User getUser(Long id){
        return userJpa.findById(id).get();
    }

    public void deleteUser(Long id){
        userJpa.deleteById(id);
    }

}
