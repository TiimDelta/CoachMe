package Delta.CoachMeSpring.Comment;

import Delta.CoachMeSpring.Training.Training;
import Delta.CoachMeSpring.User.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;


@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue
    Integer Id;
    String text;
    Integer rating;
    String mail;
    Date timePosted;
    @ManyToOne
    User user;
    @ManyToOne
    Training training;

}
