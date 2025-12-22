<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Coffee Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
        }
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 40px 20px;
        }
        .header {
            text-align: center;
            margin-bottom: 60px;
            color: white;
        }
        .header h1 {
            font-size: 3em;
            margin-bottom: 20px;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.3);
        }
        .header p {
            font-size: 1.2em;
            opacity: 0.9;
            max-width: 600px;
            margin: 0 auto;
        }
        .menu {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 25px;
            margin: 40px 0;
        }
        .menu a {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            padding: 30px 20px;
            background: rgba(255, 255, 255, 0.9);
            color: #333;
            text-decoration: none;
            border-radius: 15px;
            width: 220px;
            height: 180px;
            text-align: center;
            transition: all 0.3s ease;
            box-shadow: 0 10px 30px rgba(0,0,0,0.2);
        }
        .menu a:hover {
            transform: translateY(-10px);
            box-shadow: 0 20px 40px rgba(0,0,0,0.3);
            background: white;
        }
        .menu a i {
            font-size: 2.5em;
            margin-bottom: 15px;
        }
        .menu a:nth-child(1) { color: #007bff; }
        .menu a:nth-child(2) { color: #28a745; }
        .menu a:nth-child(3) { color: #17a2b8; }
        .menu a:nth-child(4) { color: #ffc107; }

        .menu a span {
            font-size: 1.1em;
            font-weight: bold;
            margin-top: 10px;
        }
        .menu a small {
            font-size: 0.9em;
            color: #666;
            margin-top: 8px;
            line-height: 1.4;
        }
        .info-box {
            background: rgba(255, 255, 255, 0.95);
            border-radius: 15px;
            padding: 40px;
            margin: 60px auto;
            max-width: 800px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.15);
        }
        .info-box h3 {
            color: #333;
            margin-bottom: 20px;
            font-size: 1.8em;
        }
        .info-box ul {
            list-style-type: none;
            padding: 0;
        }
        .info-box li {
            padding: 10px 0;
            border-bottom: 1px solid #eee;
            color: #555;
        }
        .info-box li:before {
            content: "✓";
            color: #28a745;
            margin-right: 10px;
            font-weight: bold;
        }
        .footer {
            text-align: center;
            margin-top: 60px;
            color: white;
            opacity: 0.8;
        }
        @media (max-width: 768px) {
            .menu a {
                width: 100%;
                max-width: 300px;
            }
            .header h1 {
                font-size: 2em;
            }
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>☕ Coffee Management System</h1>
            <p>Efficient management of coffee products, van packing optimization, and inventory control</p>
        </div>

        <div class="menu">
            <a href="coffees">
                <i class="fas fa-list"></i>
                <span>View All Coffee</span>
                <small>Browse all coffee products in inventory</small>
            </a>
            <a href="add-coffee">
                <i class="fas fa-plus-circle"></i>
                <span>Add New Coffee</span>
                <small>Add new coffee products to the system</small>
            </a>
            <a href="pack-van">
                <i class="fas fa-truck-loading"></i>
                <span>Pack Van</span>
                <small>Optimize van loading with smart algorithm</small>
            </a>
            <a href="find-coffee">
                <i class="fas fa-search"></i>
                <span>Find Coffee</span>
                <small>Search coffee by various parameters</small>
            </a>
        </div>

        <div class="info-box">
            <h3>System Features:</h3>
            <ul>
                <li>Manage different types of coffee (beans, ground, instant in jars/packets)</li>
                <li>Intelligent van packing algorithm based on price/weight ratio</li>
                <li>Advanced search with multiple parameters and filters</li>
                <li>Real-time calculation of package weight and volume</li>
                <li>Optimized sorting by value-to-weight ratio</li>
                <li>Comprehensive inventory management with stock tracking</li>
                <li>Responsive design with modern user interface</li>
            </ul>
        </div>

        <div class="footer">
            <p>© 2024 Coffee Management System | Built with Java, JSP, Servlet, and MS Access</p>
        </div>
    </div>
</body>
</html>