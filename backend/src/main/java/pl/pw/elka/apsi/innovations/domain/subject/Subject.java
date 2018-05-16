package pl.pw.elka.apsi.innovations.domain.subject;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "Subject",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    public Subject(){}

    public Subject(String name) {
        this.name = name;
    }
}
