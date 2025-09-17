package br.edu.unipaulistana.backend.Blog.domainmodel;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {
    private @Getter @Setter Long id;
    private @Getter @Setter String name;
    private @Getter @Setter Set<User> user;
}
