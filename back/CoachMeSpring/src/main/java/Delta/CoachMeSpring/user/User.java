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
    public
    String username;
    @NotNull
    public
    String firstName;
    @NotNull
    public
    String lastName;
    @NotNull
    public
    String password;
    @NotNull
    public
    String mail;
    @NotNull
    public
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

    public User( String username, String firstname, String lastname, String password, String mail, Boolean userType){
        this.username = username;
        this.firstName = firstname;
        this.lastName = lastname;
        this.password = password;
        this.mail = mail;
        this.userType = userType;
    }

    User(){

    }
}
