package com.rafaelbarreto.workshopmongo.services;

import com.rafaelbarreto.workshopmongo.domain.User;
import com.rafaelbarreto.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
}
