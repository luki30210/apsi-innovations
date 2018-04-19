package pl.pw.elka.apsi.innovations.domain.idea;
import lombok.Getter;
import lombok.Setter;
import pl.pw.elka.apsi.innovations.domain.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Idea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_username")
    User author;

    @NotNull
    String title;

    @NotNull
    String description;
}
