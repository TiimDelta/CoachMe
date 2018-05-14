package Delta.CoachMeSpring.training;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    private TrainingRepository trainingRepository;

    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    Training addTraining(Training training) {
        // here you can do some validations etc before saving the training
        return trainingRepository.save(training);
    }

    List<Training> getAllTrainings() {

        return trainingRepository.findAll();
    }

    public List<Training> getAllTrainingsSorted(String userInput) {
        return trainingRepository.findByTrainerContainingOrLocationContainingOrWorkoutContaining(userInput,userInput,userInput);
    }
}