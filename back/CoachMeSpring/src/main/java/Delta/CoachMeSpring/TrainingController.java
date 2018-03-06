package Delta.CoachMeSpring;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
