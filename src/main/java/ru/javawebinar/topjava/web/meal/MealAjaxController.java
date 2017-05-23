package ru.javawebinar.topjava.web.meal;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealWithExceed;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by web on 22.05.2017.
 */
@RestController
@RequestMapping("/ajax/meals")
public class MealAjaxController extends AbstractMealController {
    @GetMapping
    public List<MealWithExceed> getAll() {
        return super.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        super.delete(id);
    }

    @PostMapping
    public Meal create(@RequestBody Meal meal) {
       return super.create(meal);
    }

    @PostMapping("/filter")
    public List<MealWithExceed> getBetween(
            @RequestParam(value = "startDate", required = false) LocalDate startDate, @RequestParam(value = "startTime", required = false) LocalTime startTime,
            @RequestParam(value = "endDate", required = false) LocalDate endDate, @RequestParam(value = "endTime", required = false) LocalTime endTime) {
        return super.getBetween(startDate, startTime, endDate, endTime);
    }
}
