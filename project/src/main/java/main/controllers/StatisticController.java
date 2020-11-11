package main.controllers;

import lombok.extern.log4j.Log4j2;
import main.repository.StatisticRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("api/statistic")
public class StatisticController
{
    private final StatisticRepository statisticRepository;

    public StatisticController(StatisticRepository statisticRepository)
    {
        this.statisticRepository = statisticRepository;
    }

    @GetMapping("")
    public ResponseEntity getStat()
    {
        log.info("Message");
        statisticRepository.findCountCar();
        statisticRepository.getFirstDateAdd();
        statisticRepository.getSecondDateAdd();
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}