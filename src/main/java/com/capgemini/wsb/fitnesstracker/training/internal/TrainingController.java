package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.TrainingDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class TrainingController {

    private final TrainingServiceImpl trainingService;

    private


    public TrainingController(TrainingServiceImpl trainingService) {
        this.trainingService = trainingService;
    }
    @GetMapping
    public List<TrainingDto> getAllTrainigs() {
        return trainingService.getAllTrainings().stream().map();
    }


}
