package pl.pw.elka.apsi.innovations.domain.rating;

import pl.pw.elka.apsi.innovations.domain.idea.Idea;
import pl.pw.elka.apsi.innovations.domain.user.User;

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
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "VALUE", nullable = false)
    private int value;

    @Column(name = "OPINION")
    private String opinion;

    public Rating(){}

    public Rating(int value, Idea idea, User user, String opinion) {
        this.value = value;
        this.idea = idea;
        this.user = user;
        this.opinion = opinion;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getOpinion() {return opinion;}
    public void setOpinion(String opinion) {this.opinion = opinion;}

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
