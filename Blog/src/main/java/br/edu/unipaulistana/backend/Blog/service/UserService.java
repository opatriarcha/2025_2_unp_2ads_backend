package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> findAll();

    User findById(UUID id);
}
