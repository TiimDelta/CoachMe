package Delta.CoachMeSpring.training;

import Delta.CoachMeSpring.comment.Comment;
import Delta.CoachMeSpring.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

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
    public Integer id;
    @NotNull
    public
    String trainer;
    @NotNull
    public
    String location;
    @NotNull
    public
    String workout;
    @NotNull
    public
    String mail;
    @JsonManagedReference
    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
    public List<Comment> comments;



    public Training( String trainer, String location, String workout, String mail){
        this.trainer = trainer;
        this.location = location;
        this.workout = workout;
        this.mail = mail;
    }


    Training(){

    }
}
