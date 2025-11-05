<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Users</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .container { max-width: 1000px; margin: 0 auto; }
        table { width: 100%; border-collapse: collapse; margin: 20px 0; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #f2f2f2; }
        .actions a { margin-right: 10px; text-decoration: none; }
        .edit { color: #28a745; }
        .delete { color: #dc3545; }
        .add-btn {
            display: inline-block;
            padding: 10px 20px;
            background: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>All Users</h1>
        <a href="add-user" class="add-btn">Add New User</a>
        <a href="index.jsp" style="margin-left: 10px;">Back to Home</a>

        <c:if test="${not empty users}">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.email}</td>
                            <td class="actions">
                                <a href="edit-user?id=${user.id}" class="edit">Edit</a>
                                <form action="delete-user" method="post" style="display: inline;">
                                    <input type="hidden" name="id" value="${user.id}">
                                    <button type="submit" class="delete" onclick="return confirm('Delete this user?')">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty users}">
            <p>No users found. <a href="add-user">Add the first user</a></p>
        </c:if>
    </div>
</body>
</html>