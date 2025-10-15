package br.edu.unipaulistana.backend.Blog.domainmodel.repositories;

import br.edu.unipaulistana.backend.Blog.domainmodel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends
        JpaRepository <User, UUID>,
        QuerydslPredicateExecutor<User>,
        UserRepositoryCustom<User, UUID>{

    @Query("SELECT u FROM User u WHERE u.email = :email")
    public Optional<User> findByEmail(String email);

    public Optional<User> findByName(String name);
    public Optional<User> findByNameAndEmail(String name, String email);
    public List<User> findByNameStartingWithAndNameEndingWith(String name1, String name2);

    // Q1 JPQL  biusca o user por ID e faz fetch com profile e posts.
    @Query(
            """
        select distinct u
        from User u
        left join fetch u.profile
        left join fetch u.roles
        where u.id = :id
    """
    )
    Optional<User> findByIdWithProfileAndPosts(@Param("id") UUID id);

    //Q2 LPQL usuarios cujo nome contem um parametro  que tenham pelo menos N roles.
    @Query(
            """
        select u
        from User u
        where size(u.roles) >= :minRoles
        and lower(u.name) like lower(concat('%', :namePart, '%'))
        order by u.name asc
"""
    )
    List<User> findMinPostsAndNameLike(@Param("minPosts") int minPosts, @Param("namePart") String namePart);



}

