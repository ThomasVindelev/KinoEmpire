package com.kinoempire.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// DENNE CONTROLLER SKAL SANDSYNLIGVIS IKKE BRUGES, DA VI IKKE LÆNGERE ARBEJDE MED HTML

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

}
