package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingTO;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrainingMapper {

    public TrainingTO toTrainingTO(Training training) {
        if (training == null) {
            return null;
        }

        TrainingTO trainingTO = new TrainingTO();
        trainingTO.setId(training.getId());
        trainingTO.setUser(training.getUser());
        trainingTO.setStartTime(training.getStartTime());
        trainingTO.setEndTime(training.getEndTime());
        trainingTO.setActivityType(training.getActivityType());
        trainingTO.setDistance(training.getDistance());
        trainingTO.setAverageSpeed(training.getAverageSpeed());

        return trainingTO;
    }

    public List<TrainingTO> toTrainingTOList(List<Training> trainings) {
        if (trainings == null) {
            return null;
        }

        return trainings.stream()
                .map(this::toTrainingTO)
                .collect(Collectors.toList());
    }
}
