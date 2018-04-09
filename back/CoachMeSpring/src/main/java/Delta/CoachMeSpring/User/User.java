package Delta.CoachMeSpring.User;

import Delta.CoachMeSpring.Comment.Comment;
import Delta.CoachMeSpring.Training.Training;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    Integer Id;
    String username;
    String firstName;
    String lastName;
    String Password;
    String mail;
    Boolean userType;
    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    List<Training> trainings;
    @OneToMany(mappedBy="user", cascade= CascadeType.ALL)
    List<Comment> comments;

}