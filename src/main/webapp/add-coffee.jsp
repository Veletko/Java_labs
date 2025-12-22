<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Coffee</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
        }
        .container {
            max-width: 800px;
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
            margin-bottom: 10px;
            font-size: 2.2em;
        }
        .form-header p {
            color: #666;
            margin: 0;
        }
        .form-group {
            margin-bottom: 25px;
        }
        .form-row {
            display: flex;
            gap: 20px;
            margin-bottom: 25px;
        }
        .form-row .form-group {
            flex: 1;
            margin-bottom: 0;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            color: #333;
        }
        input[type="text"],
        input[type="number"],
        select {
            width: 100%;
            padding: 12px 15px;
            border: 2px solid #e1e5e9;
            border-radius: 8px;
            font-size: 16px;
            transition: all 0.3s ease;
            box-sizing: border-box;
        }
        input[type="text"]:focus,
        input[type="number"]:focus,
        select:focus {
            outline: none;
            border-color: #667eea;
            box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);
        }
        .form-hint {
            display: block;
            margin-top: 6px;
            font-size: 0.85em;
            color: #6c757d;
        }
        .btn-container {
            display: flex;
            gap: 15px;
            margin-top: 40px;
            padding-top: 30px;
            border-top: 1px solid #eee;
        }
        .btn {
            padding: 14px 30px;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            display: inline-flex;
            align-items: center;
            justify-content: center;
            gap: 8px;
            flex: 1;
        }
        .btn-submit {
            background: linear-gradient(135deg, #28a745 0%, #20c997 100%);
            color: white;
        }
        .btn-submit:hover {
            transform: translateY(-2px);
            box-shadow: 0 10px 20px rgba(40, 167, 69, 0.3);
        }
        .btn-cancel {
            background: #6c757d;
            color: white;
        }
        .btn-cancel:hover {
            background: #545b62;
            transform: translateY(-2px);
        }
        .coffee-icon {
            text-align: center;
            margin-bottom: 20px;
        }
        .coffee-icon i {
            font-size: 3em;
            color: #764ba2;
            background: linear-gradient(135deg, #667eea, #764ba2);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }
        .required::after {
            content: " *";
            color: #dc3545;
        }
        .type-options {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 15px;
            margin-top: 10px;
        }
        .type-option {
            border: 2px solid #e1e5e9;
            border-radius: 8px;
            padding: 15px;
            cursor: pointer;
            transition: all 0.3s ease;
            text-align: center;
        }
        .type-option:hover {
            border-color: #667eea;
            background: #f8f9fa;
        }
        .type-option.selected {
            border-color: #28a745;
            background: rgba(40, 167, 69, 0.1);
        }
        .type-option i {
            font-size: 1.5em;
            margin-bottom: 8px;
            display: block;
        }
        .type-option .type-name {
            font-weight: 600;
            margin-bottom: 4px;
        }
        .type-option .type-desc {
            font-size: 0.85em;
            color: #6c757d;
        }
        @media (max-width: 768px) {
            .form-row {
                flex-direction: column;
                gap: 0;
            }
            .type-options {
                grid-template-columns: 1fr;
            }
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
    <div class="container">
        <div class="form-card">
            <div class="form-header">
                <div class="coffee-icon">
                    <i class="fas fa-coffee"></i>
                </div>
                <h1>Add New Coffee Product</h1>
                <p>Fill in the details below to add a new coffee product to the inventory</p>
            </div>

            <form action="add-coffee" method="post" id="coffeeForm">
                <div class="form-group">
                    <label for="name" class="required">Coffee Name</label>
                    <input type="text" id="name" name="name" required
                           placeholder="e.g., Arabica Premium, Colombian Supremo">
                    <span class="form-hint">Enter the brand and type of coffee</span>
                </div>

                <div class="form-group">
                    <label class="required">Coffee Type</label>
                    <div class="type-options">
                        <div class="type-option" data-value="BEAN" onclick="selectType(this)">
                            <i class="fas fa-seedling"></i>
                            <div class="type-name">Bean Coffee</div>
                            <div class="type-desc">Whole coffee beans</div>
                        </div>
                        <div class="type-option" data-value="GROUND" onclick="selectType(this)">
                            <i class="fas fa-mortar-pestle"></i>
                            <div class="type-name">Ground Coffee</div>
                            <div class="type-desc">Pre-ground coffee</div>
                        </div>
                        <div class="type-option" data-value="INSTANT_JAR" onclick="selectType(this)">
                            <i class="fas fa-jar"></i>
                            <div class="type-name">Instant (Jar)</div>
                            <div class="type-desc">Instant coffee in jars</div>
                        </div>
                        <div class="type-option" data-value="INSTANT_SACHET" onclick="selectType(this)">
                            <i class="fas fa-box"></i>
                            <div class="type-name">Instant (Sachet)</div>
                            <div class="type-desc">Instant coffee in sachets</div>
                        </div>
                    </div>
                    <input type="hidden" id="type" name="type" required>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label for="weight" class="required">Net Weight (kg)</label>
                        <input type="number" id="weight" name="weight" step="0.001" min="0.001" required
                               placeholder="e.g., 1.000">
                        <span class="form-hint">Weight of coffee without packaging</span>
                    </div>
                    <div class="form-group">
                        <label for="volume" class="required">Volume (m³)</label>
                        <input type="number" id="volume" name="volume" step="0.0001" min="0.0001" required
                               placeholder="e.g., 0.002">
                        <span class="form-hint">Total volume including packaging</span>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label for="price" class="required">Price ($)</label>
                        <input type="number" id="price" name="price" step="0.01" min="0.01" required
                               placeholder="e.g., 25.50">
                        <span class="form-hint">Selling price per unit</span>
                    </div>
                    <div class="form-group">
                        <label for="packageWeight" class="required">Package Weight (kg)</label>
                        <input type="number" id="packageWeight" name="packageWeight" step="0.001" min="0" required
                               placeholder="e.g., 0.050">
                        <span class="form-hint">Weight of packaging material</span>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label for="packageType" class="required">Package Type</label>
                        <input type="text" id="packageType" name="packageType" required
                               placeholder="e.g., Vacuum Bag, Glass Jar">
                        <span class="form-hint">Type of packaging material</span>
                    </div>
                    <div class="form-group">
                        <label for="quantity" class="required">Quantity in Stock</label>
                        <input type="number" id="quantity" name="quantity" min="0" required
                               placeholder="e.g., 100">
                        <span class="form-hint">Current stock quantity</span>
                    </div>
                </div>

                <div class="form-group">
                    <div id="pricePerKg" style="
                        background: #e8f5e9;
                        padding: 15px;
                        border-radius: 8px;
                        text-align: center;
                        margin-top: 20px;
                        display: none;
                    ">
                        <strong>Price per Kilogram: </strong>
                        <span id="pricePerKgValue">$0.00/kg</span>
                    </div>
                </div>

                <div class="btn-container">
                    <button type="submit" class="btn btn-submit">
                        <i class="fas fa-plus-circle"></i> Add Coffee Product
                    </button>
                    <a href="coffees" class="btn btn-cancel">
                        <i class="fas fa-times"></i> Cancel
                    </a>
                </div>
            </form>
        </div>
    </div>

    <script>
        function selectType(element) {
            // Remove selected class from all options
            document.querySelectorAll('.type-option').forEach(opt => {
                opt.classList.remove('selected');
            });

            // Add selected class to clicked option
            element.classList.add('selected');

            // Set hidden input value
            document.getElementById('type').value = element.dataset.value;
        }

        // Auto-calculate price per kg
        function calculatePricePerKg() {
            const weight = parseFloat(document.getElementById('weight').value) || 0;
            const price = parseFloat(document.getElementById('price').value) || 0;

            if (weight > 0 && price > 0) {
                const pricePerKg = price / weight;
                document.getElementById('pricePerKgValue').textContent =
                    '$' + pricePerKg.toFixed(2) + '/kg';
                document.getElementById('pricePerKg').style.display = 'block';
            } else {
                document.getElementById('pricePerKg').style.display = 'none';
            }
        }

        // Add event listeners for auto-calculation
        document.getElementById('weight').addEventListener('input', calculatePricePerKg);
        document.getElementById('price').addEventListener('input', calculatePricePerKg);

        // Form validation
        document.getElementById('coffeeForm').addEventListener('submit', function(e) {
            const type = document.getElementById('type').value;
            if (!type) {
                e.preventDefault();
                alert('Please select a coffee type');
                return false;
            }
            return true;
        });

        // Select first type by default
        document.querySelector('.type-option[data-value="BEAN"]').click();
    </script>
</body>
</html>