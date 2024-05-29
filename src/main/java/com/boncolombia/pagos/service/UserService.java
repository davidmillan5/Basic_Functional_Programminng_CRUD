package com.boncolombia.pagos.service;

import com.boncolombia.pagos.model.User;
import com.boncolombia.pagos.repository.UserRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User save(User user){
        Optional.of(user).filter(u -> user.getName() != null)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(400), "El nombre debe estar definido"));
        Optional.of(user).filter(u -> !user.getName().isBlank())
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(400), "El nombre debe contener algun valor"));
        return repository.save(user);
    }

    public void  delete(Long id){
        repository.deleteById(id);
    }

    public Optional<User> getById(Long id){
        return repository.findById(id);
    }
}
