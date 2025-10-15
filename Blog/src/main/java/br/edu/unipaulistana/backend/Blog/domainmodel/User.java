package br.edu.unipaulistana.backend.Blog.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "TBL_USERS", indexes = {@Index( name = "IDX_EMAIL_PASSWORD", columnList = "email, password"),
    @Index( name = "IDX_EMAIL",  columnList = "email"),
        @Index( name = "IDX_PASSWORD",columnList = "password")

})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", nullable = false)
    private @Getter @Setter UUID id;

    @Column(name = "NAME", nullable = false)
    private @Getter @Setter String name;

    @Column(name = "EMAIL", nullable = false, length = 60)
    private @Getter @Setter String email;

    @Column(name = "PASSWORD", nullable = false,  length = 20)
    private @Getter @Setter String password;

    @ManyToMany
    private @Getter @Setter Set<Role> roles;

    @OneToOne
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
