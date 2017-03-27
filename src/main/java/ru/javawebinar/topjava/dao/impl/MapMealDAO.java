package ru.javawebinar.topjava.dao.impl;

import ru.javawebinar.topjava.dao.MealDAO;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by web on 27.03.2017.
 */
public class MapMealDAO implements MealDAO {
    private final static Map<Integer, Meal> DB = new ConcurrentHashMap<>();
    private final static AtomicInteger counter = new AtomicInteger(0);

    public MapMealDAO() {
        List<Meal> mealList =  Arrays.asList(
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 30), "Завтрак", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 1500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 410));

        for(Meal m : mealList) {
            int i = counter.incrementAndGet();
            m.setId(i);
            DB.put(i, m);
        }
    }

    @Override
    public void create(Meal meal) {
        int id = counter.incrementAndGet();
        meal.setId(id);
        DB.put(id, meal);
    }

    @Override
    public void update(Meal meal) {
        DB.put(meal.getId(), meal);
    }

    @Override
    public void delete(int id) {
        DB.remove(id);
    }

    @Override
    public Meal getById(int id) {
        return DB.get(id);
    }

    @Override
    public List<Meal> getAll() {
        return new ArrayList<>(DB.values());
    }
}
