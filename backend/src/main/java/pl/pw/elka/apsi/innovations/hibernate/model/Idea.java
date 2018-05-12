package pl.pw.elka.apsi.innovations.hibernate.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Idea",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "SUBJECT_ID", nullable = false)
    private Subject subject;


    @ManyToMany(targetEntity = Keyword.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "Ideas_Keywords",
            joinColumns = {@JoinColumn(name = "IDEA_ID")},
            inverseJoinColumns = {@JoinColumn(name = "KEYWORD_ID")})
    private Set<Keyword> keywords;
    @Column(name = "BENEFITS", nullable = false)
    private String benefits;

    @Column(name = "COSTS", nullable = false)
    private String costs;

    @Column(name = "STATUS", nullable = false)
    private String status; // TODO Seperate table?

    @Column(name = "ADDITION_DATE", nullable = false)
    private Date addition_date;

    @OneToMany(mappedBy = "idea")
    private Set<Rating> ratings;

    @OneToMany(mappedBy = "idea")
    private Set<Opinion> opinions;

    @OneToMany(mappedBy = "idea")
    private Set<Attachment> attachments;
}
