package com.kinoempire.demo.Service;

import com.kinoempire.demo.Repository.StatisticRepository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.*;
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

    // ALT HERUNDER ER TESTING AF TID

    private LocalTime localTimeToCompare = LocalTime.of(0, 30);
    private Month month = Month.NOVEMBER;

    private LocalDateTime localDateFrom = LocalDateTime.of(2019, month, 11, 10, 10, 00);
    private LocalDateTime localDateTo = LocalDateTime.of(2019, month, 12, 23, 10, 00);

    public List<String> getTime() throws SQLException {
        ZoneId zoneId = ZoneId.of("Europe/London");
        LocalDate localDate = LocalDate.now(zoneId);
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ResultSet resultSet = statisticRepository.getTime(
                Timestamp.valueOf(localDateFrom),
                Timestamp.valueOf(localDateTo));
        List<String> strings = new ArrayList<>();
        while (resultSet.next()) {
            String test = new String();
            test = "Hejsa";
            strings.add(test);
        }
        localTime = localDateTime.toLocalTime();
        System.out.println(localTime);
        System.out.println(localTime.isAfter(localTimeToCompare));
        System.out.println(localTime.isBefore(localTimeToCompare));
        return strings;
    }

}
