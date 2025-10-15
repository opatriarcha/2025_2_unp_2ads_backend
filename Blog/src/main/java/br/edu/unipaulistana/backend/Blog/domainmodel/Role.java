package br.edu.unipaulistana.backend.Blog.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private @Getter @Setter Long id;

    @Column(name="NAME" ,  nullable = false,  length = 20)
    private @Getter @Setter String name;

    @ManyToMany
    private @Getter @Setter Set<User> user;
}
