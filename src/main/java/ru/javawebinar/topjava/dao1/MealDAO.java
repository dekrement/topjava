package ru.javawebinar.topjava.dao1;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

/**
 * Created by web on 27.03.2017.
 */
public interface MealDAO {
    static int test = 1;
    void create(Meal meal);

    void update(Meal meal);

    void delete(int id);

    Meal getById(int id);

    List<Meal> getAll();
}
