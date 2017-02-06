package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmed = request.getParameter("confirm");

        boolean inputHasErrors = username.isEmpty() || email.isEmpty() || password.isEmpty() || (!password.equals(passwordConfirmed));

        if (inputHasErrors) {
            doGet(request, response); // show register form again
        } else {

            User user = new User(username, email, password);

            Users users = DaoFactory.getUsersDao();
            users.insert(user);
            request.getSession().setAttribute("user", user); // automatic login
            response.sendRedirect("profile");
        }

    }
}
