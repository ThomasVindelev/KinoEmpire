package com.kinoempire.demo.Service;

import com.kinoempire.demo.Repository.StatisticRepository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class StatisticService {

    private final StatisticRepository statisticRepository;
    private ResultSet resultSet;

    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }


    public int getSoldSeats(int viewingId) {
        int soldSeats = 0;
        try {
            resultSet = statisticRepository.getSoldSeats(viewingId);
            while (resultSet.next()) {
                soldSeats++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soldSeats;
    }
}
