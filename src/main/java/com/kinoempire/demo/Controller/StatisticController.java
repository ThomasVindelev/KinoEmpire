package com.kinoempire.demo.Controller;

import com.kinoempire.demo.Service.StatisticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/getSoldSeats")
    public Object getSoldSeats() {
        return statisticService.getSoldSeats();
    }

    @GetMapping("/getViewingCount")
    public Object getViewingCount() {
        return statisticService.getViewingCount();
    }

    // ALT HERUNDER ER TESTING AF TID

    @GetMapping("/getTime")
    public Object getTime() throws SQLException {
        return statisticService.getTime();
    }

}
