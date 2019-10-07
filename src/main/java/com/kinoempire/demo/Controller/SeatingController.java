package com.kinoempire.demo.Controller;

import com.kinoempire.demo.Model.Viewing;
import com.kinoempire.demo.Service.SeatingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatingController {

    private SeatingService seatingService;

    public SeatingController(SeatingService seatingService) {
        this.seatingService = seatingService;
    }

    @GetMapping("/getSeats/{id}")
    public Object seats(@PathVariable("id") int id) {
        return seatingService.getSeatsByViewing(id);
    }

}
