<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .container { max-width: 500px; margin: 0 auto; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; }
        input[type="text"], input[type="email"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .btn {
            padding: 10px 20px;
            background: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .back-link { margin-top: 15px; display: inline-block; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Edit User</h1>

        <form action="edit-user" method="post">
            <input type="hidden" name="id" value="${user.id}">

            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" value="${user.name}" required>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="${user.email}" required>
            </div>

            <button type="submit" class="btn">Update User</button>
        </form>

        <a href="users" class="back-link">Back to Users List</a>
    </div>
</body>
</html>