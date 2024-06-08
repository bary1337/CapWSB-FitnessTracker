package com.capgemini.wsb.fitnesstracker.statistics.internal;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StatisticsDto {

    private Long userId;
    private int totalTrainings;
    private double totalDistance;
    private int totalCaloriesBurned;
}

