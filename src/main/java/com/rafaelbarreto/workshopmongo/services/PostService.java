package com.rafaelbarreto.workshopmongo.services;

import com.rafaelbarreto.workshopmongo.domain.Post;
import com.rafaelbarreto.workshopmongo.domain.User;
import com.rafaelbarreto.workshopmongo.repository.PostRepository;
import com.rafaelbarreto.workshopmongo.repository.UserRepository;
import com.rafaelbarreto.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository repo;
    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
       maxDate = new Date(maxDate.getTime() + 24 * 60*60*1000);
       return repo.fullSearch(text,minDate,maxDate);
    }

}
