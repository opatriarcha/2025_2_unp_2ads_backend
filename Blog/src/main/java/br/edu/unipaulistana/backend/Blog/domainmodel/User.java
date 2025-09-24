package br.edu.unipaulistana.backend.Blog.domainmodel;

import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private @Getter @Setter UUID id;
    private @Getter @Setter String name;
    private @Getter @Setter String email;
    private @Getter @Setter String password;
    private @Getter @Setter List<Role> roles;
    private @Getter @Setter Profile profile;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
