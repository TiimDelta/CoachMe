package Delta.CoachMeSpring;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
@Setter
public class Training {
    @Id
    @GeneratedValue
    Integer Id;
    String trainerName;
    String location;
    String eMail;
    String workoutType;

}
