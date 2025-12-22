<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Coffee Management</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
        }
        .container {
            max-width: 1400px;
            margin: 0 auto;
            padding: 20px;
        }
        .header {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 30px;
            border-radius: 10px;
            margin-bottom: 30px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        }
        .header h1 {
            margin: 0;
            font-size: 2.5em;
        }
        .header p {
            margin: 10px 0 0 0;
            opacity: 0.9;
        }
        .menu {
            display: flex;
            flex-wrap: wrap;
            gap: 15px;
            margin: 30px 0;
        }
        .btn {
            display: inline-flex;
            align-items: center;
            gap: 8px;
            padding: 12px 25px;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            border: none;
            cursor: pointer;
            font-weight: 500;
            transition: all 0.3s ease;
        }
        .btn i { font-size: 1.1em; }
        .btn-primary {
            background: #007bff;
        }
        .btn-primary:hover {
            background: #0056b3;
            transform: translateY(-2px);
        }
        .btn-success {
            background: #28a745;
        }
        .btn-success:hover {
            background: #1e7e34;
            transform: translateY(-2px);
        }
        .btn-info {
            background: #17a2b8;
        }
        .btn-info:hover {
            background: #117a8b;
            transform: translateY(-2px);
        }
        .btn-warning {
            background: #ffc107;
            color: #212529;
        }
        .btn-warning:hover {
            background: #e0a800;
            transform: translateY(-2px);
        }
        .btn-danger {
            background: #dc3545;
            padding: 5px 15px;
            font-size: 0.9em;
        }
        .btn-edit {
            background: #28a745;
            color: white;
            padding: 5px 15px;
            text-decoration: none;
            border-radius: 5px;
            font-size: 0.9em;
            display: inline-block;
            margin-right: 5px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            background: white;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 5px 15px rgba(0,0,0,0.05);
        }
        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #eee;
        }
        th {
            background-color: #f8f9fa;
            font-weight: 600;
            color: #495057;
            text-transform: uppercase;
            font-size: 0.85em;
            letter-spacing: 0.5px;
        }
        tr:hover {
            background-color: #f8f9fa;
        }
        .type-badge {
            display: inline-block;
            padding: 4px 10px;
            border-radius: 20px;
            font-size: 0.8em;
            font-weight: 500;
        }
        .type-bean { background: #e3f2fd; color: #1976d2; }
        .type-ground { background: #f3e5f5; color: #7b1fa2; }
        .type-instant-jar { background: #fff3e0; color: #f57c00; }
        .type-instant-sachet { background: #e8f5e8; color: #388e3c; }
        .quantity-indicator {
            display: inline-block;
            padding: 3px 8px;
            border-radius: 10px;
            font-size: 0.8em;
            font-weight: 500;
        }
        .quantity-high { background: #d4edda; color: #155724; }
        .quantity-medium { background: #fff3cd; color: #856404; }
        .quantity-low { background: #f8d7da; color: #721c24; }
        .actions { white-space: nowrap; }
        .empty-state {
            text-align: center;
            padding: 60px 20px;
            color: #6c757d;
        }
        .empty-state i {
            font-size: 4em;
            color: #dee2e6;
            margin-bottom: 20px;
        }
        .stats {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 20px;
            margin: 30px 0;
        }
        .stat-card {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 3px 10px rgba(0,0,0,0.05);
            text-align: center;
        }
        .stat-card h3 {
            margin: 0;
            color: #6c757d;
            font-size: 0.9em;
            text-transform: uppercase;
            letter-spacing: 1px;
        }
        .stat-card .value {
            font-size: 2em;
            font-weight: bold;
            margin: 10px 0;
            color: #333;
        }
        .stat-card .trend {
            font-size: 0.9em;
            color: #28a745;
        }
        .stat-card .trend.down { color: #dc3545; }
        @media (max-width: 768px) {
            table {
                display: block;
                overflow-x: auto;
            }
            .menu {
                flex-direction: column;
            }
            .btn {
                width: 100%;
                justify-content: center;
            }
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
    <div class="container">
        <div class="header">
            <h1><i class="fas fa-coffee"></i> Coffee Products Management</h1>
            <p>Manage all coffee products in your inventory</p>
        </div>

        <div class="stats">
            <div class="stat-card">
                <h3>Total Products</h3>
                <div class="value">${coffees.size()}</div>
                <div class="trend">All Types</div>
            </div>
            <c:set var="totalQuantity" value="0" />
            <c:set var="totalValue" value="0" />
            <c:forEach var="coffee" items="${coffees}">
                <c:set var="totalQuantity" value="${totalQuantity + coffee.quantity}" />
                <c:set var="totalValue" value="${totalValue + (coffee.price * coffee.quantity)}" />
            </c:forEach>
            <div class="stat-card">
                <h3>Total Stock</h3>
                <div class="value">${totalQuantity}</div>
                <div class="trend">units</div>
            </div>
            <div class="stat-card">
                <h3>Total Value</h3>
                <div class="value">$${String.format("%.2f", totalValue)}</div>
                <div class="trend">Inventory worth</div>
            </div>
        </div>

        <div class="menu">
            <a href="add-coffee" class="btn btn-primary">
                <i class="fas fa-plus-circle"></i> Add New Coffee
            </a>
            <a href="pack-van" class="btn btn-success">
                <i class="fas fa-truck-loading"></i> Pack Van
            </a>
            <a href="find-coffee" class="btn btn-info">
                <i class="fas fa-search"></i> Find Coffee
            </a>
            <a href="index.jsp" class="btn btn-warning">
                <i class="fas fa-home"></i> Back to Home
            </a>
        </div>

        <c:if test="${not empty coffees}">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Weight</th>
                        <th>Volume</th>
                        <th>Price</th>
                        <th>Price/Kg</th>
                        <th>Package</th>
                        <th>Stock</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="coffee" items="${coffees}">
                        <tr>
                            <td>${coffee.id}</td>
                            <td>
                                <strong>${coffee.name}</strong><br>
                                <small style="color: #6c757d;">${coffee.packageType}</small>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${coffee.type == 'BEAN'}">
                                        <span class="type-badge type-bean"><i class="fas fa-seedling"></i> ${coffee.type.description}</span>
                                    </c:when>
                                    <c:when test="${coffee.type == 'GROUND'}">
                                        <span class="type-badge type-ground"><i class="fas fa-mortar-pestle"></i> ${coffee.type.description}</span>
                                    </c:when>
                                    <c:when test="${coffee.type == 'INSTANT_JAR'}">
                                        <span class="type-badge type-instant-jar"><i class="fas fa-jar"></i> ${coffee.type.description}</span>
                                    </c:when>
                                    <c:when test="${coffee.type == 'INSTANT_SACHET'}">
                                        <span class="type-badge type-instant-sachet"><i class="fas fa-box"></i> ${coffee.type.description}</span>
                                    </c:when>
                                </c:choose>
                            </td>
                            <td>${coffee.weight} kg</td>
                            <td>${String.format("%.4f", coffee.volume)} m³</td>
                            <td><strong>$${coffee.price}</strong></td>
                            <td>$${String.format("%.2f", coffee.pricePerKg)}/kg</td>
                            <td>
                                ${coffee.packageType}<br>
                                <small>Package: ${coffee.packageWeight} kg</small>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${coffee.quantity > 20}">
                                        <span class="quantity-indicator quantity-high">${coffee.quantity} units</span>
                                    </c:when>
                                    <c:when test="${coffee.quantity > 5}">
                                        <span class="quantity-indicator quantity-medium">${coffee.quantity} units</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="quantity-indicator quantity-low">${coffee.quantity} units</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td class="actions">
                                <a href="edit-coffee?id=${coffee.id}" class="btn-edit">
                                    <i class="fas fa-edit"></i> Edit
                                </a>
                                <form action="delete-coffee" method="post" style="display: inline;">
                                    <input type="hidden" name="id" value="${coffee.id}">
                                    <button type="submit" class="btn btn-danger"
                                            onclick="return confirm('Are you sure you want to delete ${coffee.name}?')">
                                        <i class="fas fa-trash"></i>
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty coffees}">
            <div class="empty-state">
                <i class="fas fa-coffee"></i>
                <h2>No Coffee Products Found</h2>
                <p>There are no coffee products in the system yet.</p>
                <a href="add-coffee" class="btn btn-primary" style="margin-top: 20px;">
                    <i class="fas fa-plus-circle"></i> Add Your First Coffee
                </a>
            </div>
        </c:if>
    </div>

    <script>
        function confirmDelete(name) {
            return confirm("Are you sure you want to delete " + name + "?");
        }
    </script>
</body>
</html>