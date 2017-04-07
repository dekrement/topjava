package ru.javawebinar.topjava;

import ru.javawebinar.topjava.matcher.ModelMatcher;
import ru.javawebinar.topjava.model.Meal;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MealTestData {
    public static final int ADMIN_MEAL_ID_1 = UserTestData.ADMIN_ID + 1;
    public static final int ADMIN_MEAL_ID_2 = UserTestData.ADMIN_ID + 2;
    public static final int ADMIN_MEAL_ID_3 = UserTestData.ADMIN_ID + 3;

    public static final int USER_MEAL_ID_1 = UserTestData.ADMIN_ID + 4;
    public static final int USER_MEAL_ID_2 = UserTestData.ADMIN_ID + 5;
    public static final int USER_MEAL_ID_3 = UserTestData.ADMIN_ID + 6;
    public static final int USER_MEAL_ID_4 = UserTestData.ADMIN_ID + 7;

    public static final Meal ADMIN_MEAL_1 = new Meal(ADMIN_MEAL_ID_1,  Timestamp.valueOf("2017-04-06 10:30:00").toLocalDateTime(), "Полюстрово с лапшей", 1001);
    public static final Meal ADMIN_MEAL_2 = new Meal(ADMIN_MEAL_ID_2,  Timestamp.valueOf("2017-04-06 15:30:00").toLocalDateTime(), "Биточек говяжий с яйцом", 400);
    public static final Meal ADMIN_MEAL_3 = new Meal(ADMIN_MEAL_ID_3,  Timestamp.valueOf("2017-04-06 20:20:00").toLocalDateTime(), "Хлеб с маслом", 600);
    public static final Meal USER_MEAL_1 = new Meal(USER_MEAL_ID_1,  Timestamp.valueOf("2017-04-07 9:00:00").toLocalDateTime(), "Жульен с грибами", 400);
    public static final Meal USER_MEAL_2 = new Meal(USER_MEAL_ID_2,  Timestamp.valueOf("2017-04-07 14:23:00").toLocalDateTime(), "Индейка в брусничном соусе", 600);
    public static final Meal USER_MEAL_3 = new Meal(USER_MEAL_ID_3,  Timestamp.valueOf("2017-04-07 21:13:00").toLocalDateTime(), "Котлета Пожарская", 400);
    public static final Meal USER_MEAL_4 = new Meal(USER_MEAL_ID_4,  Timestamp.valueOf("2017-04-08 15:00:00").toLocalDateTime(), "Последний пир", 10000);

    public static final ModelMatcher<Meal> MATCHER = new ModelMatcher<>();

}
