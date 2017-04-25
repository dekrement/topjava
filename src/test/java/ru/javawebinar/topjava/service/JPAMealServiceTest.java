package ru.javawebinar.topjava.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.Profiles;

/**
 * Created by web on 25.04.2017.
 */
@RunWith(SpringRunner.class)
@ActiveProfiles(Profiles.JPA)
public class JpaMealServiceTest extends MealServiceTest {
}
