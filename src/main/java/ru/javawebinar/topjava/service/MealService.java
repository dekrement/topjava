package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealWithExceed;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface MealService {
    Meal save(Meal meal, int userId) throws NotFoundException;

    void delete(int id, int userId) throws NotFoundException;

    Meal get(int id, int userId) throws NotFoundException;

    List<MealWithExceed> getAll(int userId, LocalDate startDate, LocalDate endDate, int calories);

    List<MealWithExceed> getAll(int userId, LocalDate startDate, LocalDate endDate, LocalTime startTime,
                                LocalTime endTime, int calories);


}