<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search Results</title>
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
        }
        .header h1 {
            color: #333;
            margin-bottom: 10px;
            font-size: 2.5em;
        }
        .header p {
            color: #666;
            margin: 0;
        }
        .search-icon {
            text-align: center;
            margin-bottom: 20px;
        }
        .search-icon i {
            font-size: 4em;
            color: #17a2b8;
            background: linear-gradient(135deg, #17a2b8, #138496);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }
        .search-criteria {
            background: #e8f5e9;
            padding: 25px;
            border-radius: 10px;
            margin-bottom: 40px;
            border-left: 4px solid #28a745;
        }
        .search-criteria h3 {
            margin: 0 0 20px 0;
            color: #155724;
            display: flex;
            align-items: center;
            gap: 10px;
        }
        .criteria-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 15px;
        }
        .criteria-item {
            background: white;
            padding: 15px;
            border-radius: 8px;
        }
        .criteria-label {
            font-weight: 600;
            color: #495057;
            margin-bottom: 5px;
            font-size: 0.9em;
        }
        .criteria-value {
            color: #212529;
            font-weight: 500;
        }
        .results-summary {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 20px;
            margin-bottom: 40px;
        }
        .summary-box {
            background: #f8f9fa;
            padding: 25px;
            border-radius: 10px;
            text-align: center;
            border: 2px solid #e1e5e9;
            transition: all 0.3s ease;
        }
        .summary-box:hover {
            border-color: #17a2b8;
            transform: translateY(-5px);
            box-shadow: 0 10px 20px rgba(0,0,0,0.1);
        }
        .summary-box i {
            font-size: 2.5em;
            margin-bottom: 15px;
            color: #17a2b8;
        }
        .summary-box .label {
            font-size: 0.9em;
            color: #6c757d;
            margin-bottom: 8px;
            text-transform: uppercase;
            letter-spacing: 1px;
        }
        .summary-box .value {
            font-size: 2em;
            font-weight: bold;
            color: #333;
        }
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
            background-color: #17a2b8;
            color: white;
            font-weight: 600;
            text-transform: uppercase;
            font-size: 0.85em;
            letter-spacing: 0.5px;
        }
        tr:hover {
            background-color: #f8f9fa;
        }
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
        .value-rating {
            display: inline-flex;
            align-items: center;
            gap: 5px;
        }
        .value-rating .stars {
            color: #ffc107;
        }
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
            flex: 1;
        }
        .btn-primary {
            background: linear-gradient(135deg, #17a2b8 0%, #138496 100%);
            color: white;
        }
        .btn-primary:hover {
            transform: translateY(-3px);
            box-shadow: 0 15px 30px rgba(23, 162, 184, 0.3);
        }
        .btn-success {
            background: linear-gradient(135deg, #28a745 0%, #1e7e34 100%);
            color: white;
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
        .sort-options {
            display: flex;
            gap: 10px;
            margin-bottom: 20px;
            flex-wrap: wrap;
        }
        .sort-btn {
            padding: 8px 16px;
            background: #f8f9fa;
            border: 2px solid #dee2e6;
            border-radius: 20px;
            cursor: pointer;
            transition: all 0.3s ease;
            font-size: 0.9em;
        }
        .sort-btn:hover {
            border-color: #17a2b8;
            background: #e2e6ea;
        }
        .sort-btn.active {
            background: #17a2b8;
            color: white;
            border-color: #17a2b8;
        }
        @media (max-width: 768px) {
            .criteria-grid {
                grid-template-columns: 1fr;
            }
            .results-summary {
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
                <div class="search-icon">
                    <i class="fas fa-search"></i>
                </div>
                <h1>Search Results</h1>
                <p>Found coffee products matching your criteria</p>
            </div>

            <div class="search-criteria">
                <h3><i class="fas fa-filter"></i> Applied Search Criteria</h3>
                <div class="criteria-grid">
                    <div class="criteria-item">
                        <div class="criteria-label">Coffee Type</div>
                        <div class="criteria-value">
                            <c:choose>
                                <c:when test="${param.type != null && !param.type.isEmpty()}">
                                    ${param.type == 'BEAN' ? 'Bean Coffee' :
                                      param.type == 'GROUND' ? 'Ground Coffee' :
                                      param.type == 'INSTANT_JAR' ? 'Instant (Jar)' :
                                      'Instant (Sachet)'}
                                </c:when>
                                <c:otherwise>All Types</c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="criteria-item">
                        <div class="criteria-label">Weight Range</div>
                        <div class="criteria-value">
                            <c:choose>
                                <c:when test="${param.minWeight != null && !param.minWeight.isEmpty() &&
                                                param.maxWeight != null && !param.maxWeight.isEmpty()}">
                                    ${param.minWeight} - ${param.maxWeight} kg
                                </c:when>
                                <c:when test="${param.minWeight != null && !param.minWeight.isEmpty()}">
                                    Min ${param.minWeight} kg
                                </c:when>
                                <c:when test="${param.maxWeight != null && !param.maxWeight.isEmpty()}">
                                    Max ${param.maxWeight} kg
                                </c:when>
                                <c:otherwise>No limit</c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="criteria-item">
                        <div class="criteria-label">Price Range</div>
                        <div class="criteria-value">
                            <c:choose>
                                <c:when test="${param.minPrice != null && !param.minPrice.isEmpty() &&
                                                param.maxPrice != null && !param.maxPrice.isEmpty()}">
                                    $${param.minPrice} - $${param.maxPrice}
                                </c:when>
                                <c:when test="${param.minPrice != null && !param.minPrice.isEmpty()}">
                                    Min $${param.minPrice}
                                </c:when>
                                <c:when test="${param.maxPrice != null && !param.maxPrice.isEmpty()}">
                                    Max $${param.maxPrice}
                                </c:when>
                                <c:otherwise>No limit</c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="criteria-item">
                        <div class="criteria-label">Price per Kg</div>
                        <div class="criteria-value">
                            <c:choose>
                                <c:when test="${param.minPricePerKg != null && !param.minPricePerKg.isEmpty() &&
                                                param.maxPricePerKg != null && !param.maxPricePerKg.isEmpty()}">
                                    $${param.minPricePerKg} - $${param.maxPricePerKg}/kg
                                </c:when>
                                <c:when test="${param.minPricePerKg != null && !param.minPricePerKg.isEmpty()}">
                                    Min $${param.minPricePerKg}/kg
                                </c:when>
                                <c:when test="${param.maxPricePerKg != null && !param.maxPricePerKg.isEmpty()}">
                                    Max $${param.maxPricePerKg}/kg
                                </c:when>
                                <c:otherwise>No limit</c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>

            <div class="results-summary">
                <div class="summary-box">
                    <i class="fas fa-coffee"></i>
                    <div class="label">Products Found</div>
                    <div class="value">${foundCoffees.size()}</div>
                </div>
                <c:set var="avgPricePerKg" value="0" />
                <c:set var="totalStock" value="0" />
                <c:set var="totalValue" value="0" />
                <c:forEach var="coffee" items="${foundCoffees}">
                    <c:set var="avgPricePerKg" value="${avgPricePerKg + coffee.pricePerKg}" />
                    <c:set var="totalStock" value="${totalStock + coffee.quantity}" />
                    <c:set var="totalValue" value="${totalValue + (coffee.price * coffee.quantity)}" />
                </c:forEach>
                <c:if test="${foundCoffees.size() > 0}">
                    <c:set var="avgPricePerKg" value="${avgPricePerKg / foundCoffees.size()}" />
                </c:if>
                <div class="summary-box">
                    <i class="fas fa-balance-scale"></i>
                    <div class="label">Avg Price/Kg</div>
                    <div class="value">$${String.format("%.2f", avgPricePerKg)}</div>
                </div>
                <div class="summary-box">
                    <i class="fas fa-boxes"></i>
                    <div class="label">Total Stock</div>
                    <div class="value">${totalStock}</div>
                </div>
                <div class="summary-box">
                    <i class="fas fa-money-bill-wave"></i>
                    <div class="label">Total Value</div>
                    <div class="value">$${String.format("%.2f", totalValue)}</div>
                </div>
            </div>

            <c:if test="${not empty foundCoffees}">
                <div class="sort-options">
                    <span style="margin-right: 10px; color: #495057; font-weight: 600;">Sort by:</span>
                    <button class="sort-btn active" onclick="sortTable('pricePerKg')">
                        <i class="fas fa-star"></i> Best Value
                    </button>
                    <button class="sort-btn" onclick="sortTable('price')">
                        <i class="fas fa-dollar-sign"></i> Price
                    </button>
                    <button class="sort-btn" onclick="sortTable('weight')">
                        <i class="fas fa-weight"></i> Weight
                    </button>
                    <button class="sort-btn" onclick="sortTable('quantity')">
                        <i class="fas fa-boxes"></i> Stock
                    </button>
                </div>

                <table id="resultsTable">
                    <thead>
                        <tr>
                            <th>Product</th>
                            <th>Type</th>
                            <th>Weight</th>
                            <th>Price</th>
                            <th>Price/Kg</th>
                            <th>Package</th>
                            <th>Stock</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="coffee" items="${foundCoffees}">
                            <tr data-priceperkg="${coffee.pricePerKg}"
                                data-price="${coffee.price}"
                                data-weight="${coffee.weight}"
                                data-quantity="${coffee.quantity}">
                                <td>
                                    <strong>${coffee.name}</strong><br>
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
                                <td>${coffee.weight} kg</td>
                                <td><strong>$${coffee.price}</strong></td>
                                <td>
                                    <div class="value-rating">
                                        $${String.format("%.2f", coffee.pricePerKg)}/kg
                                        <div class="stars">
                                            <c:choose>
                                                <c:when test="${coffee.pricePerKg > 30}">
                                                    <i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i>
                                                </c:when>
                                                <c:when test="${coffee.pricePerKg > 20}">
                                                    <i class="fas fa-star"></i><i class="fas fa-star"></i>
                                                </c:when>
                                                <c:otherwise>
                                                    <i class="fas fa-star"></i>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    ${coffee.packageType}<br>
                                    <small>Package: ${coffee.packageWeight} kg</small>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${coffee.quantity > 20}">
                                            <span style="color: #28a745; font-weight: 600;">${coffee.quantity}</span>
                                        </c:when>
                                        <c:when test="${coffee.quantity > 5}">
                                            <span style="color: #ffc107; font-weight: 600;">${coffee.quantity}</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span style="color: #dc3545; font-weight: 600;">${coffee.quantity}</span>
                                        </c:otherwise>
                                    </c:choose>
                                    units
                                </td>
                                <td>
                                    <a href="edit-coffee?id=${coffee.id}" style="
                                        background: #28a745;
                                        color: white;
                                        padding: 5px 15px;
                                        text-decoration: none;
                                        border-radius: 5px;
                                        font-size: 0.9em;
                                        display: inline-block;
                                    ">
                                        <i class="fas fa-edit"></i> Edit
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <c:if test="${empty foundCoffees}">
                <div class="empty-state">
                    <i class="fas fa-search-minus"></i>
                    <h2>No Coffee Products Found</h2>
                    <p>No products match your search criteria. Try adjusting your filters.</p>
                    <div style="margin-top: 20px;">
                        <a href="find-coffee" class="btn" style="
                            background: #17a2b8;
                            color: white;
                            padding: 12px 30px;
                            text-decoration: none;
                            border-radius: 8px;
                            display: inline-block;
                        ">
                            <i class="fas fa-redo"></i> Search Again
                        </a>
                    </div>
                </div>
            </c:if>

            <div class="btn-container">
                <a href="find-coffee" class="btn btn-primary">
                    <i class="fas fa-redo"></i> New Search
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

    <script>
        function sortTable(criteria) {
            const tbody = document.querySelector('#resultsTable tbody');
            const rows = Array.from(tbody.querySelectorAll('tr'));

            // Remove active class from all sort buttons
            document.querySelectorAll('.sort-btn').forEach(btn => {
                btn.classList.remove('active');
            });

            // Add active class to clicked button
            event.target.classList.add('active');

            // Sort rows based on criteria
            rows.sort((a, b) => {
                const aValue = parseFloat(a.dataset[criteria]);
                const bValue = parseFloat(b.dataset[criteria]);

                // For price per kg, sort descending (highest first)
                if (criteria === 'pricePerKg') {
                    return bValue - aValue;
                }
                // For other criteria, sort ascending
                return aValue - bValue;
            });

            // Clear and re-append sorted rows
            tbody.innerHTML = '';
            rows.forEach(row => tbody.appendChild(row));
        }
    </script>
</body>
</html>