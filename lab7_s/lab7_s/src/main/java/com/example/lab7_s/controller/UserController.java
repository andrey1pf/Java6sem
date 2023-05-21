package com.example.lab7_s.controller;

import com.example.lab7_s.model.User;
import com.example.lab7_s.model.UserDAO;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserController extends HttpServlet {

    private UserDAO userDao;

    @Override
    public void init() throws ServletException {
        // инициализация объекта userDao при запуске сервлета
        userDao = new UserDAO();
    }

    @GetMapping("/hello")
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            // если параметр command не указан, отображаем список всех пользователей
            List<User> users = UserDAO.getAllUsers();
            request.setAttribute("users", users);
            request.getRequestDispatcher("/users.jsp").forward(request, response);
        } else if (command.equals("view")) {
            // если параметр command равен "view", отображаем информацию о конкретном пользователе
            int id = Integer.parseInt(request.getParameter("id"));
            User user = userDao.getUserById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/user.jsp").forward(request, response);
        } else if (command.equals("add")) {
            // если параметр command равен "add", отображаем форму для добавления пользователя
            request.getRequestDispatcher("/add_user.jsp").forward(request, response);
        } else if (command.equals("edit")) {
            // если параметр command равен "edit", отображаем форму для редактирования пользователя
            int id = Integer.parseInt(request.getParameter("id"));
            User user = userDao.getUserById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/edit_user.jsp").forward(request, response);
        } else if (command.equals("delete")) {
            // если параметр command равен "delete", удаляем пользователя из базы данных и отображаем список всех пользователей
            int id = Integer.parseInt(request.getParameter("id"));
            userDao.deleteUser(id);
            List<User> users = UserDAO.getAllUsers();
            request.setAttribute("users", users);
            request.getRequestDispatcher("/users.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command.equals("add")) {
            // если параметр command равен "add", добавляем пользователя в базу данных и отображаем список всех пользователей
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            User user = new User(1, name, email);
            userDao.addUser(user);
            List<User> users = userDao.getAllUsers();
            request.setAttribute("users", users);
            request.getRequestDispatcher("/users.jsp").forward(request, response);
        } else if (command.equals("edit")) {
            // если параметр command равен "edit", обновляем информацию о пользователе в базе данных и отображаем информацию о пользователе
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            User user = new User(id, name, email);
            userDao.updateUser(user);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/user.jsp").forward(request, response);
        }
    }
}

