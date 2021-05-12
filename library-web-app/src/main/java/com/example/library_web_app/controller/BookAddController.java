package com.example.library_web_app.controller;

import com.example.library_web_app.util.BookUtil;
import dao.Context;
import dao.inter.BookDaoInter;
import models.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookAddController", urlPatterns = "/book-add")
public class BookAddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("book-add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDaoInter bookDaoInter = Context.getBookDao();
        Book book = BookUtil.createBookFromRequest(req);
        bookDaoInter.save(book);
        resp.sendRedirect("books");
    }
}
