<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pack Van</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
        }
        .container {
            max-width: 900px;
            margin: 0 auto;
            padding: 40px 20px;
        }
        .form-card {
            background: white;
            border-radius: 15px;
            padding: 40px;
            box-shadow: 0 20px 60px rgba(0,0,0,0.3);
        }
        .form-header {
            text-align: center;
            margin-bottom: 40px;
        }
        .form-header h1 {
            color: #333;
            margin-bottom: 15px;
            font-size: 2.5em;
        }
        .form-header p {
            color: #666;
            margin: 0;
            max-width: 600px;
            margin: 0 auto;
            line-height: 1.6;
        }
        .algorithm-info {
            background: #e8f5e9;
            padding: 25px;
            border-radius: 10px;
            margin-bottom: 40px;
            border-left: 4px solid #28a745;
        }
        .algorithm-info h3 {
            color: #155724;
            margin-top: 0;
            margin-bottom: 15px;
        }
        .algorithm-info ul {
            margin: 0;
            padding-left: 20px;
            color: #155724;
        }
        .algorithm-info li {
            margin-bottom: 8px;
            line-height: 1.5;
        }
        .form-group {
            margin-bottom: 25px;
        }
        .form-row {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 25px;
            margin-bottom: 30px;
        }
        .form-row .form-group {
            margin-bottom: 0;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            color: #333;
        }
        .input-with-icon {
            position: relative;
        }
        .input-with-icon i {
            position: absolute;
            left: 15px;
            top: 50%;
            transform: translateY(-50%);
            color: #667eea;
        }
        input[type="number"] {
            width: 100%;
            padding: 14px 15px 14px 45px;
            border: 2px solid #e1e5e9;
            border-radius: 8px;
            font-size: 16px;
            transition: all 0.3s ease;
            box-sizing: border-box;
        }
        input[type="number"]:focus {
            outline: none;
            border-color: #667eea;
            box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);
        }
        .form-hint {
            display: block;
            margin-top: 8px;
            font-size: 0.9em;
            color: #6c757d;
            line-height: 1.4;
        }
        .constraint-card {
            background: #f8f9fa;
            border-radius: 10px;
            padding: 20px;
            margin-bottom: 25px;
            border: 2px solid #e1e5e9;
            transition: all 0.3s ease;
        }
        .constraint-card:hover {
            border-color: #667eea;
            background: white;
        }
        .constraint-card h4 {
            margin: 0 0 15px 0;
            color: #495057;
            display: flex;
            align-items: center;
            gap: 10px;
        }
        .constraint-card h4 i {
            color: #667eea;
        }
        .btn-container {
            display: flex;
            gap: 20px;
            margin-top: 50px;
            padding-top: 30px;
            border-top: 1px solid #eee;
        }
        .btn {
            padding: 16px 35px;
            border: none;
            border-radius: 8px;
            font-size: 17px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            display: inline-flex;
            align-items: center;
            justify-content: center;
            gap: 12px;
            flex: 1;
            text-decoration: none;
            text-align: center;
        }
        .btn-pack {
            background: linear-gradient(135deg, #28a745 0%, #20c997 100%);
            color: white;
        }
        .btn-pack:hover {
            transform: translateY(-3px);
            box-shadow: 0 15px 30px rgba(40, 167, 69, 0.3);
        }
        .btn-back {
            background: #6c757d;
            color: white;
        }
        .btn-back:hover {
            background: #545b62;
            transform: translateY(-3px);
        }
        .van-icon {
            text-align: center;
            margin-bottom: 20px;
        }
        .van-icon i {
            font-size: 4em;
            color: #764ba2;
            background: linear-gradient(135deg, #667eea, #764ba2);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }
        .constraints-summary {
            background: #fff3cd;
            padding: 20px;
            border-radius: 10px;
            margin-top: 30px;
            border: 2px solid #ffeaa7;
        }
        .constraints-summary h4 {
            margin: 0 0 15px 0;
            color: #856404;
            display: flex;
            align-items: center;
            gap: 10px;
        }
        .constraints-summary ul {
            margin: 0;
            padding-left: 20px;
            color: #856404;
        }
        @media (max-width: 768px) {
            .form-row {
                grid-template-columns: 1fr;
            }
            .btn-container {
                flex-direction: column;
            }
            .btn {
                width: 100%;
            }
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
    <div class="container">
        <div class="form-card">
            <div class="form-header">
                <div class="van-icon">
                    <i class="fas fa-truck-loading"></i>
                </div>
                <h1>Pack Coffee Van</h1>
                <p>Optimize van loading using our intelligent packing algorithm. Set constraints and let the system find the most valuable combination of coffee products.</p>
            </div>

            <div class="algorithm-info">
                <h3><i class="fas fa-brain"></i> Smart Packing Algorithm</h3>
                <ul>
                    <li><strong>Value Optimization:</strong> Sorts products by price-to-weight ratio (highest first)</li>
                    <li><strong>Constraint Handling:</strong> Considers volume, weight, and cost constraints</li>
                    <li><strong>Efficient Packing:</strong> Maximizes value within given limits</li>
                    <li><strong>Real-time Calculation:</strong> Considers packaging weight and volume</li>
                    <li><strong>Stock Aware:</strong> Respects available inventory quantities</li>
                </ul>
            </div>

            <form action="pack-van" method="post" id="packForm">
                <div class="constraint-card">
                    <h4><i class="fas fa-ruler-combined"></i> Volume Constraint</h4>
                    <div class="input-with-icon">
                        <i class="fas fa-arrows-alt-v"></i>
                        <input type="number" id="vanVolume" name="vanVolume" step="0.1" min="0"
                               placeholder="e.g., 10.0 (cubic meters)">
                    </div>
                    <span class="form-hint">
                        Maximum volume capacity of the van. Leave empty for no volume limit.
                        Typical van: 10-15 m³
                    </span>
                </div>

                <div class="constraint-card">
                    <h4><i class="fas fa-dollar-sign"></i> Target Amount</h4>
                    <div class="input-with-icon">
                        <i class="fas fa-money-bill-wave"></i>
                        <input type="number" id="targetAmount" name="targetAmount" step="100" min="0"
                               placeholder="e.g., 5000.00 (dollars)">
                    </div>
                    <span class="form-hint">
                        Target total value of goods. Leave empty for no amount limit.
                        The algorithm will try to reach or exceed this value.
                    </span>
                </div>

                <div class="constraint-card">
                    <h4><i class="fas fa-weight-hanging"></i> Weight Constraint</h4>
                    <div class="input-with-icon">
                        <i class="fas fa-weight"></i>
                        <input type="number" id="maxWeight" name="maxWeight" step="100" min="0"
                               placeholder="e.g., 3000.0 (kilograms)">
                    </div>
                    <span class="form-hint">
                        Maximum weight capacity including packaging. Leave empty for no weight limit.
                        Includes both coffee and packaging weight.
                    </span>
                </div>

                <div class="constraints-summary">
                    <h4><i class="fas fa-lightbulb"></i> How it Works</h4>
                    <ul>
                        <li>Products are sorted by <strong>value density</strong> (price per kg)</li>
                        <li>The system starts with the most valuable products</li>
                        <li>Each product is added until constraints are reached</li>
                        <li>Packaging weight and volume are included in calculations</li>
                        <li>Stock availability is respected</li>
                    </ul>
                </div>

                <div class="btn-container">
                    <button type="submit" class="btn btn-pack">
                        <i class="fas fa-calculator"></i> Calculate Optimal Packing
                    </button>
                    <a href="coffees" class="btn btn-back">
                        <i class="fas fa-arrow-left"></i> Back to Coffee List
                    </a>
                </div>
            </form>
        </div>
    </div>

    <script>
        // Form validation
        document.getElementById('packForm').addEventListener('submit', function(e) {
            const vanVolume = document.getElementById('vanVolume').value;
            const targetAmount = document.getElementById('targetAmount').value;
            const maxWeight = document.getElementById('maxWeight').value;

            // At least one constraint should be specified
            if (!vanVolume && !targetAmount && !maxWeight) {
                e.preventDefault();
                alert('Please specify at least one constraint (volume, amount, or weight)');
                return false;
            }

            return true;
        });

        // Add real-time calculation preview
        function updatePreview() {
            const vanVolume = document.getElementById('vanVolume').value;
            const targetAmount = document.getElementById('targetAmount').value;
            const maxWeight = document.getElementById('maxWeight').value;

            let constraints = [];
           if (vanVolume) constraints.push(`Volume: ${vanVolume} m³`);
           if (targetAmount) constraints.push(`Target: $${targetAmount}`);
           if (maxWeight) constraints.push(`Weight: ${maxWeight} kg`);

            // You could add AJAX call here for real-time preview
        }

        // Add event listeners for real-time updates
        document.getElementById('vanVolume').addEventListener('input', updatePreview);
        document.getElementById('targetAmount').addEventListener('input', updatePreview);
        document.getElementById('maxWeight').addEventListener('input', updatePreview);
    </script>
</body>
</html>