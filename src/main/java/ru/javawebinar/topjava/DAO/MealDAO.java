package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

/**
 * Created by web on 24.03.2017.
 */
public interface MealDAO {
    void addMeal(Meal meal);

    void updateMeal(Meal meal);

    void deleteMeal(int id);

    List<Meal> getAllMeals();

    Meal getMeal(int id);
}
