package com.rafaelbarreto.workshopmongo.services;

import com.rafaelbarreto.workshopmongo.domain.User;
import com.rafaelbarreto.workshopmongo.dto.UserDTO;
import com.rafaelbarreto.workshopmongo.repository.UserRepository;
import com.rafaelbarreto.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());

    }
}
