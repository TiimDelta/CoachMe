package Delta.CoachMeSpring;


import org.springframework.stereotype.Service;

@Service
public class TrainingService {

    private TrainingRepository trainingRepository;

    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public Training addTraining(Training training) {
        // here you can do some validations etc before saving the training
        return trainingRepository.save(training);
    }
}