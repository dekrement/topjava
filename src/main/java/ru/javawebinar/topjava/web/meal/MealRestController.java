package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealWithExceed;
import ru.javawebinar.topjava.util.ValidationUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class MealRestController {
    @Autowired
    private MealService service;

    public List<MealWithExceed> getAll() {
        return service.getAll(AuthorizedUser.id(), LocalDate.MIN, LocalDate.MAX, AuthorizedUser.getCaloriesPerDay());
    }

    public List<MealWithExceed> getAll(LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime) {
        if (startDate == null)
            startDate = LocalDate.MIN;
        if (endDate == null)
            endDate = LocalDate.MAX;
        if (startTime == null)
            startTime = LocalTime.MIN;
        if (endTime == null)
            endTime = LocalTime.MAX;

        return service.getAll(AuthorizedUser.id(), startDate, endDate, startTime, endTime, AuthorizedUser.getCaloriesPerDay());
    }

    public void delete(int id) throws NotFoundException {
        service.delete(id, AuthorizedUser.id());
    }

    public Meal get(int id) throws NotFoundException {
        return service.get(id, AuthorizedUser.id());
    }

    public void save(Meal meal) {
        service.save(meal, AuthorizedUser.id());
    }

    public void update(Meal meal) throws NotFoundException {
        service.save(meal, AuthorizedUser.id());
    }
}