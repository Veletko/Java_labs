<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management System</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .container { max-width: 800px; margin: 0 auto; }
        .menu { margin: 20px 0; }
        .menu a {
            display: inline-block;
            padding: 10px 20px;
            background: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin-right: 10px;
        }
        .menu a:hover { background: #0056b3; }
    </style>
</head>
<body>
    <div class="container">
        <h1>User Management System</h1>
        <div class="menu">
            <a href="users">View All Users</a>
            <a href="add-user">Add New User</a>
        </div>
        <p>Welcome to the User Management System. Use the links above to manage users.</p>
    </div>
</body>
</html>