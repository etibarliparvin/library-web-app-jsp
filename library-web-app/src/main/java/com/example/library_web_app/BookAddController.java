package com.example.library_web_app;

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
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String author = req.getParameter("author");
        Double price = Double.valueOf(req.getParameter("price"));
        Integer stockCount = Integer.valueOf(req.getParameter("stockCount"));

        BookDaoInter bookDaoInter = Context.getBookDao();
        Book book = new Book(null, name, description, author, price, stockCount);
        bookDaoInter.save(book);
        resp.sendRedirect("books");
    }
}
