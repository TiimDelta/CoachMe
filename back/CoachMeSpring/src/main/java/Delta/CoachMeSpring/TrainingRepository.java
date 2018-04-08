package Delta.CoachMeSpring;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
    List<Training> findAll();
    List<Training> findByTrainerContaining(String userInput);

}


