package pl.pw.elka.apsi.innovations.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "Rating",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private long id;

    @ManyToOne
    @JoinColumn(name = "IDEA_ID", nullable = false)
    private Idea idea;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name = "VALUE", nullable = false)
    private int value;

    public Rating(){}

    public Rating(int value, Idea idea, User user) {
        this.value = value;
        this.idea = idea;
        this.user = user;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Idea getIdea() {
        return idea;
    }
    public void setIdea(Idea idea) {
        this.idea = idea;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
