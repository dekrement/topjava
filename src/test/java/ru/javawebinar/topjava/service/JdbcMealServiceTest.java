package ru.javawebinar.topjava.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.Profiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by web on 25.04.2017.
 */
@RunWith(SpringRunner.class)
@ActiveProfiles(Profiles.JDBC)
public class JdbcMealServiceTest extends MealServiceTest {
}
