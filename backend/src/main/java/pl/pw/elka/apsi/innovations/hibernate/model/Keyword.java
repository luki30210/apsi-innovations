package pl.pw.elka.apsi.innovations.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "Keyword",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private long id;

    @Column(name = "WORD", nullable = false)
    private String word;

    public Keyword(){}

    public Keyword(String word) {
        this.word = word;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
}
