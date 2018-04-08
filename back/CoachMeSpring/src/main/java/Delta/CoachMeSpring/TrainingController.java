package Delta.CoachMeSpring;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainingController {

    private TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @RequestMapping(value="/trainings/add", method=RequestMethod.POST,
            consumes = "application/json")
    public Training addTraining(@RequestBody Training training) {
        return trainingService.addTraining(training);
    }

    @RequestMapping(value="/trainings", method=RequestMethod.GET)
    public List<Training> getAllTrainings() {
        return trainingService.getAllTrainings();
    }

    @RequestMapping(value="/trainings/{userInput}", method=RequestMethod.GET)
    public List<Training> getAllTrainingsSorted(@PathVariable("userInput") String userInput) {
        return trainingService.getAllTrainingsSorted(userInput);
    }
}
