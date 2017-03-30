package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by web on 27.03.2017.
 */
public class MapMealDAOImpl implements MealDAO {
    private final Map<Integer, Meal> DB = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    public MapMealDAOImpl() {
        List<Meal> mealList = MealsUtil.getMeals();

        mealList.forEach(this::create);
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
