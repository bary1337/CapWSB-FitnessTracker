package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.training.internal.ActivityType;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.internal.UserDto;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

import java.util.Date;

@Data
public class TrainingTO {

    private Long id;

    private User user;

    private Date startTime;

    private Date endTime;

    private ActivityType activityType;

    private Double distance;
    private Double averageSpeed;

    @JsonCreator
    public TrainingTO() {
    }

    @JsonCreator
    public TrainingTO(Training training) {
        this.id = training.getId();
        this.user = training.getUser();
        this.startTime = training.getStartTime();
        this.endTime = training.getEndTime();
        this.activityType = training.getActivityType();
        this.distance = training.getDistance();
        this.averageSpeed = training.getAverageSpeed();
    }

}
