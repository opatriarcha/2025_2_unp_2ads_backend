package br.edu.unipaulistana.backend.Blog.controllers;

import br.edu.unipaulistana.backend.Blog.domainmodel.User;
import br.edu.unipaulistana.backend.Blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

//http://locallhost:8080/users
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll(){
        return this.userService.findAll();
    }

//    http://localhost:8080/users/{id}
    @GetMapping("/{id}")
    public User findUserById(@PathVariable UUID id){
        return this.userService.findById(id);
    }
}
