package Delta.CoachMeSpring.comment;

import Delta.CoachMeSpring.training.Training;
import Delta.CoachMeSpring.user.User;
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
