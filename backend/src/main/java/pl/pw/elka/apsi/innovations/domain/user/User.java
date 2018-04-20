package pl.pw.elka.apsi.innovations.domain.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
//@Table(name = "USERS")
public class User {
    public enum UserType { STUDENT, TEACHER }

    @Id
    String username;

    @NotNull
    String email;

    @Enumerated(EnumType.STRING)
    UserType userType = UserType.STUDENT;

//    @OneToMany(mappedBy = "author")
//    Set<Idea> ideas;
}
