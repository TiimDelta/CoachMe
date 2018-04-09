package Delta.CoachMeSpring.Training;

import Delta.CoachMeSpring.Comment.Comment;
import Delta.CoachMeSpring.User.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
public class Training {
    @Id
    @GeneratedValue
    Integer Id;
    String trainer;
    String location;
    String mail;
    String workout;
    @ManyToOne
    User user;

    @OneToMany(mappedBy="training", cascade= CascadeType.ALL)
    List<Comment> comments;

}
