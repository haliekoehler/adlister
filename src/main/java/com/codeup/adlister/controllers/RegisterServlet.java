package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

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

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

        // input
        // validation
        // process
        // output

        // input --> look for - request.getParameter
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || password.isEmpty()
            || (! password.equals(passwordConfirmation));

        if (inputHasErrors) {
            response.sendRedirect("/register");
            return;
        }

        // process --> saving/updating/selecting/deleting from a database
        // create and save a new user

        String hash = Password.hash(password); // <--- saving hashed version of password

        User user = new User(username, email, hash); // <--- using hashed version in password parameter
        DaoFactory.getUsersDao().insert(user);

        // output
        // request.getRequestDispatcher().forward()
        response.sendRedirect("/login");
    }
}
