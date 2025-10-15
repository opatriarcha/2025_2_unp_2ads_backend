package br.edu.unipaulistana.backend.Blog.domainmodel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Profile {
    @Id
    private @Getter @Setter Long id;
    private @Getter @Setter String bio;
    private @Getter @Setter String pictureUrl;

    @OneToOne
    private @Getter @Setter User user;
}

