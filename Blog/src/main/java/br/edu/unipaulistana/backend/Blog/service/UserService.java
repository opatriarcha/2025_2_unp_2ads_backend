package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
