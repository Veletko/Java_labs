<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Packing Result</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
        }
        .container {
            max-width: 1400px;
            margin: 0 auto;
            padding: 40px 20px;
        }
        .result-card {
            background: white;
            border-radius: 15px;
            padding: 40px;
            box-shadow: 0 20px 60px rgba(0,0,0,0.3);
        }
        .header {
            text-align: center;
            margin-bottom: 40px;
            padding-bottom: 30px;
            border-bottom: 2px solid #f0f0f0;
        }
        .header h1 {
            color: #333;
            margin-bottom: 10px;
            font-size: 2.5em;
        }
        .header p {
            color: #666;
            margin: 0;
            font-size: 1.1em;
        }
        .success-icon {
            text-align: center;
            margin-bottom: 20px;
        }
        .success-icon i {
            font-size: 4em;
            color: #28a745;
            background: linear-gradient(135deg, #28a745, #20c997);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }
        .summary-stats {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
            margin-bottom: 40px;
        }
        .stat-box {
            background: #f8f9fa;
            padding: 25px;
            border-radius: 10px;
            text-align: center;
            border: 2px solid transparent;
            transition: all 0.3s ease;
        }
        .stat-box:hover {
            border-color: #28a745;
            transform: translateY(-5px);
            box-shadow: 0 10px 20px rgba(0,0,0,0.1);
        }
        .stat-box i {
            font-size: 2.5em;
            margin-bottom: 15px;
            color: #667eea;
        }
        .stat-box .label {
            font-size: 0.9em;
            color: #6c757d;
            margin-bottom: 8px;
            text-transform: uppercase;
            letter-spacing: 1px;
        }
        .stat-box .value {
            font-size: 2.2em;
            font-weight: bold;
            color: #333;
            margin-bottom: 5px;
        }
        .stat-box .subtext {
            font-size: 0.9em;
            color: #28a745;
            font-weight: 500;
        }
        .stat-box .subtext.warning { color: #ffc107; }
        .stat-box .subtext.danger { color: #dc3545; }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 40px 0;
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
            background-color: #667eea;
            color: white;
            font-weight: 600;
            text-transform: uppercase;
            font-size: 0.85em;
            letter-spacing: 0.5px;
        }
        tr:hover {
            background-color: #f8f9fa;
        }
        .product-header {
            display: flex;
            align-items: center;
            gap: 10px;
        }
        .product-icon {
            width: 30px;
            height: 30px;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
        }
        .icon-bean { background: #1976d2; }
        .icon-ground { background: #7b1fa2; }
        .icon-jar { background: #f57c00; }
        .icon-sachet { background: #388e3c; }
        .type-badge {
            display: inline-block;
            padding: 4px 12px;
            border-radius: 20px;
            font-size: 0.8em;
            font-weight: 500;
        }
        .type-bean { background: #e3f2fd; color: #1976d2; }
        .type-ground { background: #f3e5f5; color: #7b1fa2; }
        .type-instant-jar { background: #fff3e0; color: #f57c00; }
        .type-instant-sachet { background: #e8f5e8; color: #388e3c; }
        .btn-container {
            display: flex;
            gap: 15px;
            margin-top: 50px;
            padding-top: 30px;
            border-top: 1px solid #eee;
            flex-wrap: wrap;
        }
        .btn {
            padding: 15px 30px;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            display: inline-flex;
            align-items: center;
            justify-content: center;
            gap: 10px;
            text-decoration: none;
        }
        .btn-primary {
            background: linear-gradient(135deg, #007bff 0%, #0056b3 100%);
            color: white;
            flex: 1;
        }
        .btn-primary:hover {
            transform: translateY(-3px);
            box-shadow: 0 15px 30px rgba(0, 123, 255, 0.3);
        }
        .btn-success {
            background: linear-gradient(135deg, #28a745 0%, #1e7e34 100%);
            color: white;
            flex: 1;
        }
        .btn-success:hover {
            transform: translateY(-3px);
            box-shadow: 0 15px 30px rgba(40, 167, 69, 0.3);
        }
        .btn-light {
            background: #f8f9fa;
            color: #333;
            border: 2px solid #dee2e6;
        }
        .btn-light:hover {
            background: #e2e6ea;
            transform: translateY(-3px);
        }
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
        .constraints-info {
            background: #f8f9fa;
            padding: 20px;
            border-radius: 10px;
            margin-bottom: 30px;
        }
        .constraints-info h4 {
            margin: 0 0 15px 0;
            color: #495057;
            display: flex;
            align-items: center;
            gap: 10px;
        }
        .constraint-item {
            display: flex;
            justify-content: space-between;
            padding: 10px 0;
            border-bottom: 1px solid #dee2e6;
        }
        .constraint-item:last-child {
            border-bottom: none;
        }
        .constraint-label {
            font-weight: 600;
            color: #495057;
        }
        .constraint-value {
            color: #212529;
        }
        .efficiency-score {
            background: linear-gradient(135deg, #20c997, #28a745);
            color: white;
            padding: 10px 20px;
            border-radius: 20px;
            font-weight: bold;
            display: inline-block;
            margin-top: 10px;
        }
        @media (max-width: 768px) {
            .summary-stats {
                grid-template-columns: 1fr;
            }
            .btn-container {
                flex-direction: column;
            }
            table {
                display: block;
                overflow-x: auto;
            }
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
    <div class="container">
        <div class="result-card">
            <div class="header">
                <div class="success-icon">
                    <i class="fas fa-check-circle"></i>
                </div>
                <h1>Van Packing Complete</h1>
                <p>Optimal packing solution calculated based on your constraints</p>
            </div>

            <div class="constraints-info">
                <h4><i class="fas fa-sliders-h"></i> Applied Constraints</h4>
                <div class="constraint-item">
                    <div class="constraint-label">Volume Limit:</div>
                    <div class="constraint-value">
                        <c:choose>
                            <c:when test="${vanVolume != null}">
                                ${vanVolume} m³
                                <span class="efficiency-score">
                                    ${String.format("%.1f", (totalVolume/vanVolume)*100)}% utilized
                                </span>
                            </c:when>
                            <c:otherwise>No limit</c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="constraint-item">
                    <div class="constraint-label">Target Amount:</div>
                    <div class="constraint-value">
                        <c:choose>
                            <c:when test="${targetAmount != null}">
                                $${String.format("%.2f", targetAmount)}
                                <span class="efficiency-score">
                                    ${String.format("%.1f", (totalAmount/targetAmount)*100)}% achieved
                                </span>
                            </c:when>
                            <c:otherwise>No limit</c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="constraint-item">
                    <div class="constraint-label">Weight Limit:</div>
                    <div class="constraint-value">
                        <c:choose>
                            <c:when test="${maxWeight != null}">
                                ${maxWeight} kg
                                <span class="efficiency-score">
                                    ${String.format("%.1f", (totalWeight/maxWeight)*100)}% utilized
                                </span>
                            </c:when>
                            <c:otherwise>No limit</c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>

            <div class="summary-stats">
                <div class="stat-box">
                    <i class="fas fa-boxes"></i>
                    <div class="label">Total Products</div>
                    <div class="value">${packedCoffees.size()}</div>
                    <div class="subtext">Different types of coffee</div>
                </div>
                <div class="stat-box">
                    <i class="fas fa-cube"></i>
                    <div class="label">Total Volume</div>
                    <div class="value">${String.format("%.3f", totalVolume)} m³</div>
                    <c:if test="${vanVolume != null}">
                        <div class="subtext
                            <c:choose>
                                <c:when test="${(totalVolume/vanVolume)*100 >= 90}">success</c:when>
                                <c:when test="${(totalVolume/vanVolume)*100 >= 70}">warning</c:when>
                                <c:otherwise>danger</c:otherwise>
                            </c:choose>">
                            ${String.format("%.1f", (totalVolume/vanVolume)*100)}% of capacity
                        </div>
                    </c:if>
                </div>
                <div class="stat-box">
                    <i class="fas fa-money-bill-wave"></i>
                    <div class="label">Total Value</div>
                    <div class="value">$${String.format("%.2f", totalAmount)}</div>
                    <c:if test="${targetAmount != null}">
                        <div class="subtext
                            <c:choose>
                                <c:when test="${(totalAmount/targetAmount)*100 >= 100}">success</c:when>
                                <c:when test="${(totalAmount/targetAmount)*100 >= 80}">warning</c:when>
                                <c:otherwise>danger</c:otherwise>
                            </c:choose>">
                            ${String.format("%.1f", (totalAmount/targetAmount)*100)}% of target
                        </div>
                    </c:if>
                </div>
                <div class="stat-box">
                    <i class="fas fa-weight-hanging"></i>
                    <div class="label">Total Weight</div>
                    <div class="value">${String.format("%.1f", totalWeight)} kg</div>
                    <c:if test="${maxWeight != null}">
                        <div class="subtext
                            <c:choose>
                                <c:when test="${(totalWeight/maxWeight)*100 >= 90}">success</c:when>
                                <c:when test="${(totalWeight/maxWeight)*100 >= 70}">warning</c:when>
                                <c:otherwise>danger</c:otherwise>
                            </c:choose>">
                            ${String.format("%.1f", (totalWeight/maxWeight)*100)}% of limit
                        </div>
                    </c:if>
                </div>
            </div>

            <c:if test="${not empty packedCoffees}">
                <h2 style="color: #333; margin-bottom: 20px;">
                    <i class="fas fa-list-ol"></i> Packed Products (${packedCoffees.size()})
                </h2>
                <table>
                    <thead>
                        <tr>
                            <th>Product</th>
                            <th>Type</th>
                            <th>Unit Details</th>
                            <th>Quantity</th>
                            <th>Total Weight</th>
                            <th>Total Volume</th>
                            <th>Total Value</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="coffee" items="${packedCoffees}">
                            <tr>
                                <td>
                                    <div class="product-header">
                                        <div class="product-icon
                                            <c:choose>
                                                <c:when test="${coffee.type == 'BEAN'}">icon-bean</c:when>
                                                <c:when test="${coffee.type == 'GROUND'}">icon-ground</c:when>
                                                <c:when test="${coffee.type == 'INSTANT_JAR'}">icon-jar</c:when>
                                                <c:when test="${coffee.type == 'INSTANT_SACHET'}">icon-sachet</c:when>
                                            </c:choose>">
                                            <i class="fas
                                                <c:choose>
                                                    <c:when test="${coffee.type == 'BEAN'}">fa-seedling</c:when>
                                                    <c:when test="${coffee.type == 'GROUND'}">fa-mortar-pestle</c:when>
                                                    <c:when test="${coffee.type == 'INSTANT_JAR'}">fa-jar</c:when>
                                                    <c:when test="${coffee.type == 'INSTANT_SACHET'}">fa-box</c:when>
                                                </c:choose>">
                                            </i>
                                        </div>
                                        <strong>${coffee.name}</strong>
                                    </div>
                                    <small style="color: #6c757d;">${coffee.packageType}</small>
                                </td>
                                <td>
                                    <span class="type-badge
                                        <c:choose>
                                            <c:when test="${coffee.type == 'BEAN'}">type-bean</c:when>
                                            <c:when test="${coffee.type == 'GROUND'}">type-ground</c:when>
                                            <c:when test="${coffee.type == 'INSTANT_JAR'}">type-instant-jar</c:when>
                                            <c:when test="${coffee.type == 'INSTANT_SACHET'}">type-instant-sachet</c:when>
                                        </c:choose>">
                                        ${coffee.type.description}
                                    </span>
                                </td>
                                <td>
                                    <small>
                                        Weight: ${coffee.weight} kg<br>
                                        Volume: ${String.format("%.4f", coffee.volume)} m³<br>
                                        Price: $${coffee.price}<br>
                                        Price/kg: $${String.format("%.2f", coffee.pricePerKg)}
                                    </small>
                                </td>
                                <td>
                                    <strong>${coffee.quantity}</strong> units
                                </td>
                                <td>
                                    ${String.format("%.2f", coffee.totalWeight * coffee.quantity)} kg
                                </td>
                                <td>
                                    ${String.format("%.4f", coffee.volume * coffee.quantity)} m³
                                </td>
                                <td>
                                    <strong>$${String.format("%.2f", coffee.price * coffee.quantity)}</strong>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <c:if test="${empty packedCoffees}">
                <div class="empty-state">
                    <i class="fas fa-exclamation-circle"></i>
                    <h2>No Products Could Be Packed</h2>
                    <p>No coffee products could be packed with the given constraints.</p>
                    <p>Try adjusting your constraints or check if there is enough stock available.</p>
                </div>
            </c:if>

            <div class="btn-container">
                <a href="pack-van" class="btn btn-primary">
                    <i class="fas fa-redo"></i> Pack Another Van
                </a>
                <a href="coffees" class="btn btn-success">
                    <i class="fas fa-list"></i> View All Coffee
                </a>
                <a href="index.jsp" class="btn btn-light">
                    <i class="fas fa-home"></i> Back to Home
                </a>
            </div>
        </div>
    </div>
</body>
</html>