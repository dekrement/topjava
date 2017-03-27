package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealDAO;
import ru.javawebinar.topjava.dao.impl.MapMealDAO;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by web on 24.03.2017.
 */
public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(MealServlet.class);
    private final MealDAO mealDAO;

    public MealServlet() {
        mealDAO = new MapMealDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("doPost request");
        request.setCharacterEncoding("UTF-8");
        String dateTimeStr = request.getParameter("dateTime");
        String description = request.getParameter("description");
        String caloriesStr = request.getParameter("calories");
        String mealIdStr = request.getParameter("id");
        Meal meal = new Meal(LocalDateTime.parse(dateTimeStr), description, Integer.valueOf(caloriesStr));
        if (mealIdStr == null || mealIdStr.length() == 0) {
            mealDAO.create(meal);
        } else {
            meal.setId(Integer.parseInt(mealIdStr));
            mealDAO.update(meal);
        }
        response.sendRedirect(request.getContextPath() + "/meals");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("doGet request");
        String action = request.getParameter("action");
        String forward = "/meals.jsp";

        if (action == null)
            action = "meals";

        if (action.equalsIgnoreCase("update")) {
            request.setAttribute("meal", mealDAO.getById(Integer.parseInt(request.getParameter("id"))));
            forward = "/update.jsp";
        } else if (action.equalsIgnoreCase("add")) {
            forward = "/update.jsp";
        } else if (action.equalsIgnoreCase("delete")) {
            mealDAO.delete(Integer.parseInt(request.getParameter("id")));
            response.sendRedirect(request.getContextPath() + "/meals");
            return;
        } else {
            List<MealWithExceed> mealWithExceedList =
                    MealsUtil.getFilteredWithExceeded(mealDAO.getAll(), LocalTime.MIN, LocalTime.MAX, 2000);
            request.setAttribute("meals", mealWithExceedList);
        }

        request.getRequestDispatcher(forward).forward(request, response);
    }
}
