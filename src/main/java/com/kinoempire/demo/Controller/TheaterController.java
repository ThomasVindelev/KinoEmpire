package com.kinoempire.demo.Controller;

import com.kinoempire.demo.Service.TheaterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheaterController {

    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping("/theater")
    public Object getTheater() {
        return theaterService.getTheater();
    }

}
