package com.kinoempire.demo.Controller;

import com.kinoempire.demo.Model.Seat;
import com.kinoempire.demo.Service.ViewingService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@RestController
public class ViewingController {

    private final ViewingService viewingService;

    public ViewingController(ViewingService viewingService) {
        this.viewingService = viewingService;
    }

    @GetMapping("/getSeats/{id}")
    public Object seats(@PathVariable("id") int id) {
        return viewingService.getSeatsByViewing(id);
    }

    @GetMapping("/getViewing/{id}")
    public Object getViewingById(@PathVariable("id") int id) {
        return viewingService.getViewingById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/reserveSeats/{id}")
    public void reserveSeats(@RequestBody Seat[] seats, @PathVariable("id") int id) {
        viewingService.reserveSeats(seats, id);
    }
}
