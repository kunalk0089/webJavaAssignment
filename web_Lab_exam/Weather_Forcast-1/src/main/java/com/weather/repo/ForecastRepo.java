package com.weather.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weather.entity.Forecast;

public interface ForecastRepo extends JpaRepository<Forecast, Integer> {
    List< Forecast> getByDate(LocalDate date);
}
