package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryCustom<User, UUID> {
    public Optional<br.edu.unipaulistana.backend.Blog.domainmodel.User> findByIdWithProfileAndPostsCriteria(java.util.UUID id);

    public List<br.edu.unipaulistana.backend.Blog.domainmodel.User> findByMinRolesAndNameLikeCriteria(int minRoles, String name);
}