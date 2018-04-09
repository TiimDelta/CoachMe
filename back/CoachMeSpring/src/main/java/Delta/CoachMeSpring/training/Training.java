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
    String trainer;
    @NotNull
    String location;
    @NotNull
    String workout;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    @OneToMany(mappedBy="training", cascade= CascadeType.ALL)
    List<Comment> comments;

}
