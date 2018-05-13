package pl.pw.elka.apsi.innovations.domain.subject;

import javax.persistence.*;

@Entity
@Table(name = "Subject",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    public Subject(){}

    public Subject(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
