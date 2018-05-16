package Delta.CoachMeSpring.comment;

import Delta.CoachMeSpring.training.Training;
import Delta.CoachMeSpring.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @NotNull
    @Size(max = 250)
    public
    String text;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time")
    public Date timePosted = new Date();
    @JsonBackReference
    @ManyToOne()
    public Training training;
    public String mail;

    public Comment( String text){
        this.text = text;
        //this.timePosted = timePosted;
    }

    Comment(){

    }
}

