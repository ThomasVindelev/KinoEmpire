package com.kinoempire.demo.Controller;

import com.kinoempire.demo.Service.StatisticService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/getSoldSeats/{id}")
    public Object getSoldSeats(@PathVariable("id") int viewingId) {
        return statisticService.getSoldSeats(viewingId);
    }

}
