package com.capgemini.wsb.fitnesstracker.statistics.internal;

import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class StatisticsMapper {

    public static StatisticsDto mapToDto(Statistics statisticsEntity) {

        StatisticsDto statisticsDto = new StatisticsDto();
        statisticsDto.setUserId(statisticsEntity.getId());
        statisticsDto.setTotalTrainings(statisticsEntity.getTotalTrainings());
        statisticsDto.setTotalDistance(statisticsEntity.getTotalDistance());
        statisticsDto.setTotalCaloriesBurned(statisticsEntity.getTotalCaloriesBurned());

        return statisticsDto;
    }

    public static Statistics mapToEntity(StatisticsDto statisticsDto){

        Statistics statistics  = new Statistics();
        // TODO
        statistics.setTotalTrainings(statisticsDto.getTotalTrainings());
        statistics.setTotalDistance(statisticsDto.getTotalDistance());
        statistics.setTotalCaloriesBurned(statisticsDto.getTotalCaloriesBurned());

        return statistics;
    }
}

