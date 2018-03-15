package Delta.CoachMeSpring;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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

}
