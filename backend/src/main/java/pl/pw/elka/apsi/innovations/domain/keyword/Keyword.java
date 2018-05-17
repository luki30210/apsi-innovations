package pl.pw.elka.apsi.innovations.domain.keyword;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "Keyword",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class Keyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @NotNull
    @Column(name = "WORD")
    private String word;

    public Keyword() {}

    public Keyword(String word) {
        this.word = word;
    }
}
