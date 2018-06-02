package pl.pw.elka.apsi.innovations.domain.keyword;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "Keyword")
public class Keyword {
    @Id
    @NotNull
    @Column(name = "WORD")
    private String word;

    public Keyword() {}

    public Keyword(String word) {
        this.word = word;
    }
}
