package Delta.CoachMeSpring.comment;

import Delta.CoachMeSpring.training.Training;
import Delta.CoachMeSpring.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;
    @NotNull
    @Size(max = 250)
    public
    String text;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time")
    private Date timePosted = new Date();
    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_id", nullable = false)
    Training training;
    */

    public Comment( String text){
        this.text = text;
        //this.timePosted = timePosted;
    }

    Comment(){

    }
}

