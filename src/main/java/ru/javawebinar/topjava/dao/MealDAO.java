package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

/**
 * Created by web on 27.03.2017.
 */
public interface MealDAO {

    void create(Meal meal);

    void update(Meal meal);

    void delete(int id);

    Meal getById(int id);

    List<Meal> getAll();
}
