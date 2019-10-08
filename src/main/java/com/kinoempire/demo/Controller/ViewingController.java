package com.kinoempire.demo.Controller;

import com.kinoempire.demo.Service.ViewingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewingController {

    private ViewingService viewingService;

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
}
