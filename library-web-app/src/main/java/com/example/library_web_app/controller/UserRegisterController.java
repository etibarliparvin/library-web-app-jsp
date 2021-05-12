package com.example.library_web_app.controller;

import dao.Context;
import dao.impl.UserDaoImpl;
import dao.inter.UserDaoInter;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserRegisterController", urlPatterns = "/user-register")
public class UserRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("user-register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(null, name, surname, email, password);
        UserDaoInter userDaoInter = Context.getUserDao();
        userDaoInter.save(user);
        resp.sendRedirect("books");
    }
}
