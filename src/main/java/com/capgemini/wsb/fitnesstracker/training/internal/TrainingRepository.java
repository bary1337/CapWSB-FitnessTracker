package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.sql.Timestamp;
interface TrainingRepository extends JpaRepository<Training, Long> {

    List<Training> findByUserId(Long userId);

    @Query("SELECT t FROM Training t WHERE t.endTime > :cutoffDate")
    List<Training> findTrainingsCompletedAfter(Timestamp cutoffDate);

    List<Training> findByActivityType(ActivityType activityType);
}
