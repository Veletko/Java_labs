package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoffeeDAO {
    private final Connection connection;

    public CoffeeDAO() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    public CoffeeDAO(Connection connection) {
        this.connection = connection;
    }

    // CRUD операции
    public void insertCoffee(Coffee coffee) throws SQLException {
        String sql = "INSERT INTO coffee (name, type, weight, volume, price, package_weight, package_type, quantity) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, coffee.getName());
            statement.setString(2, coffee.getType().name());
            statement.setDouble(3, coffee.getWeight());
            statement.setDouble(4, coffee.getVolume());
            statement.setDouble(5, coffee.getPrice());
            statement.setDouble(6, coffee.getPackageWeight());
            statement.setString(7, coffee.getPackageType());
            statement.setInt(8, coffee.getQuantity());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    coffee.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public List<Coffee> getAllCoffees() throws SQLException {
        List<Coffee> coffees = new ArrayList<>();
        String sql = "SELECT * FROM coffee ORDER BY name";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Coffee coffee = mapResultSetToCoffee(resultSet);
                coffees.add(coffee);
            }
        }
        return coffees;
    }

    public Coffee getCoffeeById(int id) throws SQLException {
        String sql = "SELECT * FROM coffee WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToCoffee(resultSet);
                }
            }
        }
        return null;
    }

    public void updateCoffee(Coffee coffee) throws SQLException {
        String sql = "UPDATE coffee SET name = ?, type = ?, weight = ?, volume = ?, " +
                "price = ?, package_weight = ?, package_type = ?, quantity = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, coffee.getName());
            statement.setString(2, coffee.getType().name());
            statement.setDouble(3, coffee.getWeight());
            statement.setDouble(4, coffee.getVolume());
            statement.setDouble(5, coffee.getPrice());
            statement.setDouble(6, coffee.getPackageWeight());
            statement.setString(7, coffee.getPackageType());
            statement.setInt(8, coffee.getQuantity());
            statement.setInt(9, coffee.getId());
            statement.executeUpdate();
        }
    }

    public void deleteCoffee(int id) throws SQLException {
        String sql = "DELETE FROM coffee WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    // Поиск по диапазону параметров
    public List<Coffee> findCoffeeByRange(Coffee.CoffeeType type, Double minWeight, Double maxWeight,
                                          Double minPrice, Double maxPrice, Double minPricePerKg,
                                          Double maxPricePerKg) throws SQLException {
        List<Coffee> coffees = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM coffee WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (type != null) {
            sql.append(" AND type = ?");
            params.add(type.name());
        }
        if (minWeight != null) {
            sql.append(" AND weight >= ?");
            params.add(minWeight);
        }
        if (maxWeight != null) {
            sql.append(" AND weight <= ?");
            params.add(maxWeight);
        }
        if (minPrice != null) {
            sql.append(" AND price >= ?");
            params.add(minPrice);
        }
        if (maxPrice != null) {
            sql.append(" AND price <= ?");
            params.add(maxPrice);
        }

        sql.append(" ORDER BY price/weight"); // Сортировка по цене за кг

        try (PreparedStatement statement = connection.prepareStatement(sql.toString())) {
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i + 1, params.get(i));
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Coffee coffee = mapResultSetToCoffee(resultSet);

                    // Фильтрация по цене за кг (если указана)
                    if (minPricePerKg != null && coffee.getPricePerKg() < minPricePerKg) {
                        continue;
                    }
                    if (maxPricePerKg != null && coffee.getPricePerKg() > maxPricePerKg) {
                        continue;
                    }

                    coffees.add(coffee);
                }
            }
        }
        return coffees;
    }

    // Алгоритм упаковки фургона
    public List<Coffee> packVan(Double vanVolume, Double targetAmount, Double maxWeight) throws SQLException {
        List<Coffee> allCoffees = getAllCoffees();
        List<Coffee> selectedCoffees = new ArrayList<>();

        // Сортируем по соотношению цена/вес (самое выгодное первое)
        allCoffees.sort((c1, c2) -> Double.compare(c2.getPricePerKg(), c1.getPricePerKg()));

        Double currentVolume = 0.0;
        Double currentAmount = 0.0;
        Double currentWeight = 0.0;

        for (Coffee coffee : allCoffees) {
            if (coffee.getQuantity() > 0) {
                // Рассчитываем, сколько единиц этого кофе можно взять
                int maxUnitsByVolume = vanVolume != null ?
                        (int) Math.floor((vanVolume - currentVolume) / coffee.getVolume()) : Integer.MAX_VALUE;
                int maxUnitsByWeight = maxWeight != null ?
                        (int) Math.floor((maxWeight - currentWeight) / coffee.getTotalWeight()) : Integer.MAX_VALUE;
                int maxUnitsByAmount = targetAmount != null ?
                        (int) Math.floor((targetAmount - currentAmount) / coffee.getPrice()) : Integer.MAX_VALUE;
                int maxUnitsByQuantity = coffee.getQuantity();

                int unitsToTake = Math.min(maxUnitsByVolume,
                        Math.min(maxUnitsByWeight,
                                Math.min(maxUnitsByAmount, maxUnitsByQuantity)));

                if (unitsToTake > 0) {
                    Coffee packedCoffee = new Coffee(
                            coffee.getId(),
                            coffee.getName(),
                            coffee.getType(),
                            coffee.getWeight(),
                            coffee.getVolume(),
                            coffee.getPrice(),
                            coffee.getPackageWeight(),
                            coffee.getPackageType(),
                            unitsToTake
                    );

                    selectedCoffees.add(packedCoffee);

                    currentVolume += coffee.getVolume() * unitsToTake;
                    currentAmount += coffee.getPrice() * unitsToTake;
                    currentWeight += coffee.getTotalWeight() * unitsToTake;

                    // Проверяем, достигли ли мы лимитов
                    if (vanVolume != null && currentVolume >= vanVolume) break;
                    if (targetAmount != null && currentAmount >= targetAmount) break;
                    if (maxWeight != null && currentWeight >= maxWeight) break;
                }
            }
        }

        return selectedCoffees;
    }

    private Coffee mapResultSetToCoffee(ResultSet resultSet) throws SQLException {
        return new Coffee(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                Coffee.CoffeeType.valueOf(resultSet.getString("type")),
                resultSet.getDouble("weight"),
                resultSet.getDouble("volume"),
                resultSet.getDouble("price"),
                resultSet.getDouble("package_weight"),
                resultSet.getString("package_type"),
                resultSet.getInt("quantity")
        );
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}