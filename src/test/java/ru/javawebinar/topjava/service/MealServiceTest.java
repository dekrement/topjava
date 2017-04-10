package ru.javawebinar.topjava.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.DbPopulator;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.*;
import static org.junit.Assert.*;

/**
 * Created by web on 07.04.2017.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class MealServiceTest {
    static {
        SLF4JBridgeHandler.install();
    }

    @Autowired
    MealService service;

    @Autowired
    private DbPopulator dbPopulator;

    @Before
    public void setUp() throws Exception {
        dbPopulator.execute();
    }

    @Test
    public void testGet() throws Exception {
        Meal adminMeal = service.get(ADMIN_MEAL_ID_2, ADMIN_ID);
        MealTestData.MATCHER.assertEquals(ADMIN_MEAL_2, adminMeal);
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundGet() throws Exception {
        //USER tries to access ADMIN's meal
        service.get(ADMIN_MEAL_ID_2, USER_ID);
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(USER_MEAL_ID_1, USER_ID);
        MealTestData.MATCHER.assertCollectionEquals(
                Arrays.asList(USER_MEAL_4, USER_MEAL_3, USER_MEAL_2),
                service.getAll(USER_ID)
        );
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundDelete() throws Exception {
        //ADMIN tries to delete USER's meal
        service.delete(USER_MEAL_ID_1, ADMIN_ID);
    }

    @Test
    public void testGetBetweenDates() throws Exception {
        final LocalDate start = Timestamp.valueOf("2017-04-08 14:00:00").toLocalDateTime().toLocalDate();
        final LocalDate end = Timestamp.valueOf("2017-04-08 16:00:00").toLocalDateTime().toLocalDate();
        MealTestData.MATCHER.assertCollectionEquals(Arrays.asList(USER_MEAL_4), service.getBetweenDates(start, end, USER_ID));
    }

    @Test
    public void testGetBetweenDateTimes() throws Exception {
        final LocalDateTime start = Timestamp.valueOf("2017-04-06 10:00:00").toLocalDateTime();
        final LocalDateTime end = Timestamp.valueOf("2017-04-06 11:01:00").toLocalDateTime();
        MealTestData.MATCHER.assertCollectionEquals(Arrays.asList(ADMIN_MEAL_1), service.getBetweenDateTimes(start, end, ADMIN_ID));
    }

    @Test
    public void testGetAll() throws Exception {
        MealTestData.MATCHER.assertCollectionEquals(
                Arrays.asList(ADMIN_MEAL_3, ADMIN_MEAL_2, ADMIN_MEAL_1),
                service.getAll(ADMIN_ID)
        );
    }

    @Test
    public void testUpdate() throws Exception {
        final Meal meal = new Meal();
        meal.setId(ADMIN_MEAL_2.getId());
        meal.setCalories(ADMIN_MEAL_2.getCalories());
        meal.setDateTime(ADMIN_MEAL_2.getDateTime());

        meal.setDescription("new description");
        ADMIN_MEAL_2.setDescription("new description");

        service.update(meal, ADMIN_ID);
        MealTestData.MATCHER.assertEquals(meal, service.get(ADMIN_MEAL_ID_2, ADMIN_ID));
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundUpdate() {
        service.update(ADMIN_MEAL_3, USER_ID);
    }

    @Test
    public void testSave() throws Exception {
        Meal newMeal = new Meal(LocalDateTime.of(2001, Month.APRIL, 14, 9, 30), "Кефир", 510);
        Meal created = service.save(newMeal, USER_ID);
        newMeal.setId(created.getId());
        MealTestData.MATCHER.assertCollectionEquals(
                Arrays.asList(USER_MEAL_4, USER_MEAL_3, USER_MEAL_2, USER_MEAL_1, newMeal),
                service.getAll(USER_ID));
    }

}