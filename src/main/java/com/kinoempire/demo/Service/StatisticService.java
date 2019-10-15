package com.kinoempire.demo.Service;

import com.kinoempire.demo.Repository.StatisticRepository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticService {

    private final StatisticRepository statisticRepository;
    private ResultSet resultSet;

    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }


    public Integer getSoldSeats() {
        Integer soldSeats = 0;
        try {
            resultSet = statisticRepository.getSoldSeats();
            while (resultSet.next()) {
                soldSeats = resultSet.getInt("COUNT(id)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soldSeats;
    }

    public Integer getViewingCount() {
        Integer viewings = 0;
        try {
            resultSet = statisticRepository.getViewingCount();
            while (resultSet.next()) {
                viewings = resultSet.getInt("COUNT(id)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viewings;
    }
}
