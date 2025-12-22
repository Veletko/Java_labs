<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Coffee</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
        }
        .container {
            max-width: 1000px;
            margin: 0 auto;
            padding: 40px 20px;
        }
        .search-card {
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
            margin-bottom: 15px;
            font-size: 2.5em;
        }
        .header p {
            color: #666;
            margin: 0;
            max-width: 700px;
            margin: 0 auto;
            line-height: 1.6;
        }
        .search-icon {
            text-align: center;
            margin-bottom: 20px;
        }
        .search-icon i {
            font-size: 4em;
            color: #764ba2;
            background: linear-gradient(135deg, #667eea, #764ba2);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }
        .search-form {
            display: grid;
            gap: 25px;
        }
        .filter-section {
            background: #f8f9fa;
            padding: 25px;
            border-radius: 10px;
            border: 2px solid #e1e5e9;
        }
        .filter-section h3 {
            margin: 0 0 20px 0;
            color: #495057;
            display: flex;
            align-items: center;
            gap: 10px;
        }
        .filter-section h3 i {
            color: #667eea;
        }
        .form-row {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 20px;
            margin-bottom: 20px;
        }
        .form-row:last-child {
            margin-bottom: 0;
        }
        .form-group {
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
        input[type="number"],
        select {
            width: 100%;
            padding: 12px 15px 12px 45px;
            border: 2px solid #e1e5e9;
            border-radius: 8px;
            font-size: 16px;
            transition: all 0.3s ease;
            box-sizing: border-box;
        }
        input[type="number"]:focus,
        select:focus {
            outline: none;
            border-color: #667eea;
            box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);
        }
        .range-inputs {
            display: flex;
            gap: 10px;
            align-items: center;
        }
        .range-inputs .input-with-icon {
            flex: 1;
        }
        .range-inputs .separator {
            color: #6c757d;
            font-weight: bold;
        }
        .form-hint {
            display: block;
            margin-top: 8px;
            font-size: 0.9em;
            color: #6c757d;
            line-height: 1.4;
        }
        .btn-container {
            display: flex;
            gap: 20px;
            margin-top: 40px;
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
        }
        .btn-search {
            background: linear-gradient(135deg, #17a2b8 0%, #138496 100%);
            color: white;
        }
        .btn-search:hover {
            transform: translateY(-3px);
            box-shadow: 0 15px 30px rgba(23, 162, 184, 0.3);
        }
        .btn-reset {
            background: #6c757d;
            color: white;
        }
        .btn-reset:hover {
            background: #545b62;
            transform: translateY(-3px);
        }
        .btn-back {
            background: #f8f9fa;
            color: #333;
            border: 2px solid #dee2e6;
        }
        .btn-back:hover {
            background: #e2e6ea;
            transform: translateY(-3px);
        }
        .search-tips {
            background: #e8f5e9;
            padding: 20px;
            border-radius: 10px;
            margin-top: 30px;
            border-left: 4px solid #28a745;
        }
        .search-tips h4 {
            margin: 0 0 15px 0;
            color: #155724;
            display: flex;
            align-items: center;
            gap: 10px;
        }
        .search-tips ul {
            margin: 0;
            padding-left: 20px;
            color: #155724;
        }
        .search-tips li {
            margin-bottom: 8px;
            line-height: 1.5;
        }
        .preset-filters {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 15px;
            margin-top: 15px;
        }
        .preset-btn {
            padding: 12px 20px;
            background: #f8f9fa;
            border: 2px solid #dee2e6;
            border-radius: 8px;
            cursor: pointer;
            transition: all 0.3s ease;
            text-align: center;
        }
        .preset-btn:hover {
            border-color: #17a2b8;
            background: #e2e6ea;
        }
        .preset-btn.active {
            border-color: #17a2b8;
            background: #17a2b8;
            color: white;
        }
        .preset-btn i {
            margin-right: 8px;
        }
        @media (max-width: 768px) {
            .form-row {
                grid-template-columns: 1fr;
            }
            .btn-container {
                flex-direction: column;
            }
            .preset-filters {
                grid-template-columns: 1fr;
            }
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
    <div class="container">
        <div class="search-card">
            <div class="header">
                <div class="search-icon">
                    <i class="fas fa-search"></i>
                </div>
                <h1>Find Coffee Products</h1>
                <p>Search through your coffee inventory using advanced filters. Leave fields empty for no limit on that parameter.</p>
            </div>

            <form action="find-coffee" method="post" id="searchForm">
                <!-- Type Filter -->
                <div class="filter-section">
                    <h3><i class="fas fa-filter"></i> Product Type</h3>
                    <div class="form-group">
                        <label for="type">Coffee Type</label>
                        <div class="input-with-icon">
                            <i class="fas fa-coffee"></i>
                            <select id="type" name="type">
                                <option value="">All Types</option>
                                <option value="BEAN">Bean Coffee</option>
                                <option value="GROUND">Ground Coffee</option>
                                <option value="INSTANT_JAR">Instant (Jar)</option>
                                <option value="INSTANT_SACHET">Instant (Sachet)</option>
                            </select>
                        </div>
                    </div>

                    <div class="preset-filters">
                        <div class="preset-btn" onclick="applyPreset('value')">
                            <i class="fas fa-star"></i> Best Value
                        </div>
                        <div class="preset-btn" onclick="applyPreset('cheap')">
                            <i class="fas fa-dollar-sign"></i> Most Affordable
                        </div>
                        <div class="preset-btn" onclick="applyPreset('stock')">
                            <i class="fas fa-boxes"></i> High Stock
                        </div>
                        <div class="preset-btn" onclick="applyPreset('lightweight')">
                            <i class="fas fa-weight"></i> Lightweight
                        </div>
                    </div>
                </div>

                <!-- Weight Filter -->
                <div class="filter-section">
                    <h3><i class="fas fa-weight-hanging"></i> Weight Filters</h3>
                    <div class="form-row">
                        <div class="form-group">
                            <label>Net Weight Range (kg)</label>
                            <div class="range-inputs">
                                <div class="input-with-icon">
                                    <i class="fas fa-arrow-down"></i>
                                    <input type="number" id="minWeight" name="minWeight" step="0.001" min="0"
                                           placeholder="Min">
                                </div>
                                <div class="separator">to</div>
                                <div class="input-with-icon">
                                    <i class="fas fa-arrow-up"></i>
                                    <input type="number" id="maxWeight" name="maxWeight" step="0.001" min="0"
                                           placeholder="Max">
                                </div>
                            </div>
                            <span class="form-hint">Filter by coffee weight without packaging</span>
                        </div>
                    </div>
                </div>

                <!-- Price Filter -->
                <div class="filter-section">
                    <h3><i class="fas fa-money-bill-wave"></i> Price Filters</h3>
                    <div class="form-row">
                        <div class="form-group">
                            <label>Unit Price Range ($)</label>
                            <div class="range-inputs">
                                <div class="input-with-icon">
                                    <i class="fas fa-dollar-sign"></i>
                                    <input type="number" id="minPrice" name="minPrice" step="0.01" min="0"
                                           placeholder="Min">
                                </div>
                                <div class="separator">to</div>
                                <div class="input-with-icon">
                                    <i class="fas fa-dollar-sign"></i>
                                    <input type="number" id="maxPrice" name="maxPrice" step="0.01" min="0"
                                           placeholder="Max">
                                </div>
                            </div>
                            <span class="form-hint">Filter by individual unit price</span>
                        </div>
                        <div class="form-group">
                            <label>Price per Kg Range ($/kg)</label>
                            <div class="range-inputs">
                                <div class="input-with-icon">
                                    <i class="fas fa-balance-scale"></i>
                                    <input type="number" id="minPricePerKg" name="minPricePerKg" step="0.01" min="0"
                                           placeholder="Min">
                                </div>
                                <div class="separator">to</div>
                                <div class="input-with-icon">
                                    <i class="fas fa-balance-scale"></i>
                                    <input type="number" id="maxPricePerKg" name="maxPricePerKg" step="0.01" min="0"
                                           placeholder="Max">
                                </div>
                            </div>
                            <span class="form-hint">Filter by price per kilogram (value density)</span>
                        </div>
                    </div>
                </div>

                <div class="search-tips">
                    <h4><i class="fas fa-lightbulb"></i> Search Tips</h4>
                    <ul>
                        <li>Use <strong>Price per Kg</strong> filter to find the best value products</li>
                        <li>For van packing, focus on high value-to-weight ratio products</li>
                        <li>Combine multiple filters for precise searching</li>
                        <li>Empty fields mean no limit for that parameter</li>
                        <li>Results are automatically sorted by price per kg (best value first)</li>
                    </ul>
                </div>

                <div class="btn-container">
                    <button type="submit" class="btn btn-search">
                        <i class="fas fa-search"></i> Search Coffee
                    </button>
                    <button type="button" onclick="resetForm()" class="btn btn-reset">
                        <i class="fas fa-redo"></i> Reset Filters
                    </button>
                    <a href="coffees" class="btn btn-back">
                        <i class="fas fa-arrow-left"></i> Back to List
                    </a>
                </div>
            </form>
        </div>
    </div>

    <script>
        // Apply preset filters
        function applyPreset(preset) {
            resetForm();

            switch(preset) {
                case 'value':
                    // Best value (high price per kg)
                    document.getElementById('minPricePerKg').value = '15';
                    document.getElementById('maxPricePerKg').value = '50';
                    break;
                case 'cheap':
                    // Most affordable (low price per kg)
                    document.getElementById('minPricePerKg').value = '5';
                    document.getElementById('maxPricePerKg').value = '15';
                    break;
                case 'stock':
                    // High stock
                    // Note: Stock filter would need to be added to backend
                    break;
                case 'lightweight':
                    // Lightweight products
                    document.getElementById('minWeight').value = '0.1';
                    document.getElementById('maxWeight').value = '0.5';
                    break;
            }

            // Highlight active preset button
            document.querySelectorAll('.preset-btn').forEach(btn => {
                btn.classList.remove('active');
            });
            event.target.classList.add('active');
        }

        // Reset form
        function resetForm() {
            document.getElementById('searchForm').reset();
            document.querySelectorAll('.preset-btn').forEach(btn => {
                btn.classList.remove('active');
            });
        }

        // Form validation
        document.getElementById('searchForm').addEventListener('submit', function(e) {
            const minWeight = document.getElementById('minWeight').value;
            const maxWeight = document.getElementById('maxWeight').value;
            const minPrice = document.getElementById('minPrice').value;
            const maxPrice = document.getElementById('maxPrice').value;
            const minPricePerKg = document.getElementById('minPricePerKg').value;
            const maxPricePerKg = document.getElementById('maxPricePerKg').value;

            // Validate ranges
            if (minWeight && maxWeight && parseFloat(minWeight) > parseFloat(maxWeight)) {
                e.preventDefault();
                alert('Minimum weight cannot be greater than maximum weight');
                return false;
            }

            if (minPrice && maxPrice && parseFloat(minPrice) > parseFloat(maxPrice)) {
                e.preventDefault();
                alert('Minimum price cannot be greater than maximum price');
                return false;
            }

            if (minPricePerKg && maxPricePerKg && parseFloat(minPricePerKg) > parseFloat(maxPricePerKg)) {
                e.preventDefault();
                alert('Minimum price per kg cannot be greater than maximum price per kg');
                return false;
            }

            return true;
        });
    </script>
</body>
</html>