package pl.pw.elka.apsi.innovations.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "User",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    public User(){}

    public User(String name) {
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
