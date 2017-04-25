package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.springframework.context.annotation.Profile;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.Profiles;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;
@Profile(Profiles.ACTIVE_DB)
public class UserServlet extends HttpServlet {
    private static final Logger LOG = getLogger(UserServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.valueOf(request.getParameter("userId"));
        AuthorizedUser.setId(userId);
        response.sendRedirect("meals");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("forward to users");
        request.getRequestDispatcher("/users.jsp").forward(request, response);
    }
}
