package com.kinoempire.demo.Controller;

import com.kinoempire.demo.Model.Viewing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class SeatingController {

    @GetMapping("/getSeats")
    public Object seats() {
        List<Viewing> viewList = new ArrayList<>();
        HashMap<String, String> test = new HashMap<>();
        Viewing viewing = new Viewing();
        viewing.setSeat(1);
        viewing.setRow(1);
        viewList.add(viewing);
        test.put("Message", "ff");
        return test;
    }

}
