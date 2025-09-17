package br.edu.unipaulistana.backend.Blog.domainmodel;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {
    private @Getter @Setter Long id;
    private @Getter @Setter String title;
    private @Getter @Setter String content;
    private @Getter @Setter User user;
    private @Getter @Setter Set<Tag> tags;

}
