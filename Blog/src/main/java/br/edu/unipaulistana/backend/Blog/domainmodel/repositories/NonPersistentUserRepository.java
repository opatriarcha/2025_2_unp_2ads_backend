package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.User;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;


@Component
public class NonPersistentUserRepository {

    private List<User> internalState = new LinkedList<>();

    public NonPersistentUserRepository() {
        Faker faker = new Faker();
        for( int i = 0; i < 100; i++ ) {
            User user = new User(
                    UUID.randomUUID(),
                    faker.name().fullName(),
                    faker.internet().emailAddress(),
                    faker.internet().password(),
                    null,
                    null
            );
            this.internalState.add(user);
        }

    }

    public List<User> findAll() {
        return this.internalState.stream().toList();
    }

    public User findById(UUID id) {
        for(User user : this.internalState) {
            if(user.getId().equals(id))
                return user;
        }
        return null;
    }

    public void removeById(UUID id) {
        this.internalState.removeIf(
                user ->
                        user.getId().equals(id)
        );
    }

    public User create(User user) {
        this.internalState.add(user);
        return user;
    }

    public User update(User user) {
        this.internalState.remove(user);
        this.internalState.add(user);
        return user;
    }
}
