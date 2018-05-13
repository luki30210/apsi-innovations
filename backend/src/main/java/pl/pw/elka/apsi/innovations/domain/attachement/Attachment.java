package pl.pw.elka.apsi.innovations.domain.attachement;

import pl.pw.elka.apsi.innovations.domain.idea.Idea;

import javax.persistence.*;

@Entity
@Table(name = "Attachment",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private long id;

    @ManyToOne
    @JoinColumn(name = "IDEA_ID", nullable = false)
    private Idea idea;

    @Column(name = "FILE", nullable = false)
    private byte[] file;

    public Attachment(){}

    public Attachment(byte[] file, Idea idea) {
        this.file = file;
        this.idea = idea;
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

    public byte[] getFile() {
        return file;
    }
    public void setFile(byte[] file) {
        this.file = file;
    }
}
