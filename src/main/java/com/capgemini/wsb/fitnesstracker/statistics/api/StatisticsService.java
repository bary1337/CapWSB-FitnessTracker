package com.capgemini.wsb.fitnesstracker.statistics.api;
import com.capgemini.wsb.fitnesstracker.statistics.internal.StatisticsDto;
import com.capgemini.wsb.fitnesstracker.statistics.internal.StatisticsRepository;
import com.capgemini.wsb.fitnesstracker.statistics.internal.StatisticsMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class StatisticsService {

    private final  StatisticsRepository statisticsRepository;
    private final StatisticsMapper statisticsMapper;

    public List<Statistics> getAllStatistics() {
        return statisticsRepository.findAll();
    }

    public Statistics saveStatistics(StatisticsDto statisticsDto) {
        Statistics statistics = statisticsMapper.mapToEntity(statisticsDto);
        return statisticsRepository.save(statistics);
    }
}
