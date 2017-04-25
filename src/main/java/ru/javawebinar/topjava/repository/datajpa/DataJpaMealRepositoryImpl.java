package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DataJpaMealRepositoryImpl implements MealRepository {
    @PersistenceContext
    EntityManager em;

    @Autowired
    private CrudMealRepository crudRepository;

    @Override
    public Meal save(Meal meal, int userId) {
        User ref = em.getReference(User.class, userId);
        if (meal.isNew()) {
            meal.setUser(ref);
        } else if (get(meal.getId(), userId) == null) {
            return null;
        }
        meal.setUser(ref);
        crudRepository.save(meal);
        return meal;
    }

    @Override
    public boolean delete(int id, int userId) {
        return crudRepository.delete(id, userId) == 1;
    }

/*    @Override
    public Meal get(int id, int userId) {
        Meal meal = crudRepository.findOne(id);
        if (meal != null && meal.getId() != userId)
            return null;
        return meal;
    }*/

    @Override
    public Meal get(int id, int userId) {
        return crudRepository.findOneByIdAndUserId(id, userId);
    }

    @Override
    public List<Meal> getAll(int userId) {
        return crudRepository.findAllByUserIdOrderByDateTimeDesc(userId);
    }

    @Override
    public List<Meal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return crudRepository.findByUserIdAndDateTimeBetweenOrderByDateTimeDesc(userId, startDate, endDate);
    }

}
