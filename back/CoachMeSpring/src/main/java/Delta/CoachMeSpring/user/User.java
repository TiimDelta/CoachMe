package Delta.CoachMeSpring.user;

import Delta.CoachMeSpring.comment.Comment;
import Delta.CoachMeSpring.training.Training;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;
    @NotNull
    @Column(unique = true)
    String username;
    @NotNull
    String firstName;
    @NotNull
    String lastName;
    @NotNull
    String password;
    @NotNull
    String mail;
    @NotNull
    Boolean userType;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt = new Date();
    /*
    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    List<Training> trainings;
    @OneToMany(mappedBy="user", cascade= CascadeType.ALL)
    List<Comment> comments;
    */
}