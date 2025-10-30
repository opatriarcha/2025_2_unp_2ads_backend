package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom<User, UUID>{

    @PersistenceContext
    private final EntityManager entityManager;

    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<User> findByIdWithProfileAndPostsCriteria(UUID id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        Root<User> root = criteriaQuery.from(User.class);
        Fetch<User, ?> profileFetch = root.fetch("profile", JoinType.LEFT);
        Fetch<User, ?> rolesFetch = root.fetch("roles", JoinType.LEFT);

        criteriaQuery.select(root)
                .distinct(true)
                .where(criteriaBuilder.equal(root.get("id"), id));

        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
        List<User> users = query.getResultList();

        return users.stream().findFirst();
    }

    @Override
    public List<User> findByMinRolesAndNameLikeCriteria(int minRoles, String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        Root<User> root = criteriaQuery.from(User.class);

        criteriaQuery.select(root)
                .where(
                        criteriaBuilder.and(
                                criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.size(root.get("roles")), minRoles),
                                criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name + "%")
                        )
                )
                .orderBy(criteriaBuilder.asc(root.get("name")));

        return  this.entityManager.createQuery(criteriaQuery).getResultList();
    }
}
