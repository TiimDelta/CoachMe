package Delta.CoachMeSpring.training;

import Delta.CoachMeSpring.comment.Comment;
import Delta.CoachMeSpring.user.User;
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
