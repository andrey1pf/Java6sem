<%@ page import="org.example.model.User" %>

<html>
<head>
    <title>User Information</title>
</head>
<body>
<h1>User Information</h1>
<table>
    <%
        User user = (User) request.getAttribute("user");
    %>
    <tr>
        <td>ID:</td>
        <td>
            <%= user.getId() %>
        </td>
    </tr>
    <tr>
        <td>Name:</td>
        <td>
            <%= user.getName() %>
        </td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>
            <%= user.getEmail() %>
        </td>
    </tr>
</table>
</body>
</html>