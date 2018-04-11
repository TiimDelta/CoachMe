package Delta.CoachMeSpring.training;

import Delta.CoachMeSpring.comment.Comment;
import Delta.CoachMeSpring.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "trainings")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;
    @NotNull
    public
    String trainer;
    @NotNull
    String location;
    @NotNull
    String workout;
    @NotNull
    String mail;
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    @OneToMany(mappedBy="training", cascade= CascadeType.ALL)
    List<Comment> comments;
    */

    public Training( String trainer, String location, String workout, String mail){
        this.trainer = trainer;
        this.location = location;
        this.workout = workout;
        this.mail = mail;
    }

    Training(){

    }
}
