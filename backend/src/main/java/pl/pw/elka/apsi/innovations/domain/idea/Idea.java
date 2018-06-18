package pl.pw.elka.apsi.innovations.domain.idea;

import lombok.Getter;
import lombok.Setter;
import pl.pw.elka.apsi.innovations.domain.attachement.Attachment;
import pl.pw.elka.apsi.innovations.domain.keyword.Keyword;
import pl.pw.elka.apsi.innovations.domain.rating.Rating;
import pl.pw.elka.apsi.innovations.domain.subject.Subject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Idea",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    //@NotNull
    @ManyToOne
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;


    @ManyToMany(targetEntity = Keyword.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "Ideas_Keywords",
            joinColumns = {@JoinColumn(name = "IDEA_ID")},
            inverseJoinColumns = {@JoinColumn(name = "KEYWORD_ID")})
    private Set<Keyword> keywords;

    @NotNull
    @Column(name = "BENEFITS")
    private String benefits;

    @NotNull
    @Column(name = "COSTS")
    private String costs;

    @NotNull
    @Column(name = "STATUS")
    private String status = "new"; // TODO Seperate table?

    @NotNull
    @Column(name = "ADDITION_DATE")
    private Date additionDate = new Date();

    @OneToMany(mappedBy = "idea")
    private Set<Rating> ratings;

    @OneToMany(mappedBy = "idea")
    private Set<Attachment> attachments;
}
