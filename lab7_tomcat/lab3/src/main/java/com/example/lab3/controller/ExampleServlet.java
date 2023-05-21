package com.example.lab3.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name = "ExampleServlet", value = "/lab3")
public class ExampleServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("users").forward(req, res);
    }
}
