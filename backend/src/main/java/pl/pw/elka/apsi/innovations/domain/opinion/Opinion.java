package pl.pw.elka.apsi.innovations.domain.opinion;

import pl.pw.elka.apsi.innovations.domain.idea.Idea;
import pl.pw.elka.apsi.innovations.domain.user.User;

import javax.persistence.*;

@Entity
@Table(name = "Opinion",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class Opinion {

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
    private String text;

    public Opinion(){}

    public Opinion(String text, Idea idea, User user) {
        this.text = text;
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

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
