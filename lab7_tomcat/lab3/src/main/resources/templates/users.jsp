<%@ page import="com.example.lab3.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lab3.model.UserDAO" %>

<html>
<head>
    <title>Users List</title>
</head>
<body>
<h1>Users List</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <% List<User> users = UserDAO.getAllUsers(); %>
    <% for (User user : users) { %>
    <tr>
        <td>
            <%= user.getId() %>
        </td>
        <td>
            <%= user.getName() %>
        </td>
        <td>
            <%= user.getEmail() %>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
