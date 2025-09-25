package br.edu.unipaulistana.backend.Blog.controllers;

import br.edu.unipaulistana.backend.Blog.domainmodel.User;
import br.edu.unipaulistana.backend.Blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//http://locallhost:8080/users
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(this.userService.findAll());
    }

//    GET http://localhost:8080/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable UUID id){
        return ResponseEntity.ok(this.userService.findById(id));
    }

    //DELETE http://localshot:8080/users/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable UUID id){
        this.userService.deleteById(id);
        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(this.userService.create(user),  HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return new ResponseEntity<>(this.userService.update(user),  HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<User> patchUser(@RequestBody User user){
        return new ResponseEntity<>(this.userService.partialUpdate(user), HttpStatus.CREATED);
    }
}
