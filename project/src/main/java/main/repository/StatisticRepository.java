package main.repository;

import main.model.Statistic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface StatisticRepository extends CrudRepository<Statistic, Integer>
{
    @Query("SELECT count(1) FROM cars")
    Integer findCountCar();

    @Query("SELECT min(first_add) FROM statistics")
    LocalDateTime getFirstDateAdd();

    @Query("SELECT max(second_add) FROM statistics")
    LocalDateTime getSecondDateAdd();
}