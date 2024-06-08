package com.capgemini.wsb.fitnesstracker.statistics.internal;
import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsService;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping
    public List<Statistics> getAllStatistics() {
        return statisticsService.getAllStatistics();
    }

    @PostMapping
    public Statistics createStatistics(@RequestBody StatisticsDto statisticsDto) {

        return statisticsService.saveStatistics(statisticsDto);
        // Tworzenie obiektu Statistics z DTO
//        User user = new User();
//        user.setId(statisticsDto.getUserId());
//        statistics.setUser(user);
//        statistics.setTotalTrainings(statisticsDto.getTotalTrainings());
//        statistics.setTotalDistance(statisticsDto.getTotalDistance());
//        statistics.setTotalCaloriesBurned(statisticsDto.getTotalCaloriesBurned());

        // Zapisanie obiektu Statistics przez serwis
//        return statisticsService.saveStatistics(statistics);
    }
}
