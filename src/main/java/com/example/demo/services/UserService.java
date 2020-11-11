package com.example.demo.services;

import com.example.demo.jpamysql.UserJpa;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired private UserJpa userJpa;

    public Page<User> getUsers(Pageable pageable){
        return (Page<User>)userJpa.findAll(pageable);
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

    public Long getTotal(){
       return userJpa.getTotalUser();
    }

}
