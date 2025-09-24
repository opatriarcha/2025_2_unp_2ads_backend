package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.User;
import br.edu.unipaulistana.backend.Blog.domainmodel.repositories.NonPersistentUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final NonPersistentUserRepository repository;

    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }

    @Override
    public User findById(UUID id) {
        return this.repository.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        this.repository.removeById(id);
    }

    @Override
    public User create(User user) {
        if(user.getId() == null)
            user.setId(UUID.randomUUID());
        return this.repository.create(user);
    }

    @Override
    public User update(User user) {
        return this.repository.update(user);
    }

    @Override
    public User partialUpdate(User user) {
        return  this.repository.update(user);
    }
}
