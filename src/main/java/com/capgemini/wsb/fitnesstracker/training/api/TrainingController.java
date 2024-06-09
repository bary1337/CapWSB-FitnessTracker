package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingTO;
import com.capgemini.wsb.fitnesstracker.training.internal.TrainingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.List;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.capgemini.wsb.fitnesstracker.training.internal.ActivityType;
import com.capgemini.wsb.fitnesstracker.user.api.UserTO;
import com.capgemini.wsb.fitnesstracker.user.internal.UserDto;
@RestController
@RequestMapping("/v1/trainings")
public class TrainingController {

    private final TrainingServiceImpl trainingService;

    @Autowired
    public TrainingController(TrainingServiceImpl trainingService) {
        this.trainingService = trainingService;
    }
    @GetMapping("/trainings")
    public ResponseEntity<List<TrainingTO>> getAllTrainings() {
        List<TrainingTO> trainings = trainingService.getAllTrainings();
        return ResponseEntity.ok(trainings);
    }
    @PostMapping("/trainings/add")
    public ResponseEntity<Training> createTraining(@RequestBody Training training) {
        Training newTraining = trainingService.createTraining(training);
        return new ResponseEntity<>(newTraining, HttpStatus.CREATED);
    }

    @GetMapping("/trainings/userid/{userId}")
    public ResponseEntity<List<Training>> getTrainingsForUser(@PathVariable Long userId) {
        List<Training> trainings = trainingService.getTrainingsForUser(userId);
        return ResponseEntity.ok(trainings);
    }

    @GetMapping("/trainings/completed-after")
    public ResponseEntity<List<Training>> getTrainingsCompletedAfter(
            @RequestParam("date") String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
        Timestamp timestamp = Timestamp.valueOf(dateTime);
        List<Training> trainings = trainingService.getTrainingsCompletedAfter(timestamp);
        return ResponseEntity.ok(trainings);
    }

    @GetMapping("trainings/by-activity")
    public ResponseEntity<List<Training>> getTrainingsByActivityType(@RequestParam ActivityType activityType) {
        List<Training> trainings = trainingService.getTrainingsByActivityType(activityType);
        return ResponseEntity.ok(trainings);
    }

    @PutMapping("trainings/update/{trainingId}")
    public ResponseEntity<TrainingTO> updateTraining(@PathVariable Long trainingId, @RequestBody TrainingTO trainingTO) {
        TrainingTO updatedTrainingTO = trainingService.updateTraining(trainingId, trainingTO);
        return ResponseEntity.ok(updatedTrainingTO);
    }

    @GetMapping("{distance}")
    public ResponseEntity<List<Training>> getAllTrainingsByDistanceGreaterThan(@PathVariable double distance) {
        List<Training> trainings = trainingService.findTrainingsByDistanceGreaterThan(distance);
        return ResponseEntity.ok(trainings);
    }

}
