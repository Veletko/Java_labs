package com.example;

public class Coffee {
    private Integer id;
    private String name;
    private CoffeeType type;
    private Double weight;
    private Double volume;
    private Double price;
    private Double packageWeight;
    private String packageType;
    private Integer quantity;

    public enum CoffeeType {
        BEAN("Зерно"),
        GROUND("Молотый"),
        INSTANT_JAR("Растворимый в банках"),
        INSTANT_SACHET("Растворимый в пакетиках");

        private final String description;

        CoffeeType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    // Конструкторы
    public Coffee() {}

    public Coffee(Integer id, String name, CoffeeType type, Double weight, Double volume,
                  Double price, Double packageWeight, String packageType, Integer quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.volume = volume;
        this.price = price;
        this.packageWeight = packageWeight;
        this.packageType = packageType;
        this.quantity = quantity;
    }

    public Coffee(String name, CoffeeType type, Double weight, Double volume,
                  Double price, Double packageWeight, String packageType, Integer quantity) {
        this(null, name, type, weight, volume, price, packageWeight, packageType, quantity);
    }

    // Геттеры и сеттеры
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public CoffeeType getType() { return type; }
    public void setType(CoffeeType type) { this.type = type; }

    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }

    public Double getVolume() { return volume; }
    public void setVolume(Double volume) { this.volume = volume; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Double getPackageWeight() { return packageWeight; }
    public void setPackageWeight(Double packageWeight) { this.packageWeight = packageWeight; }

    public String getPackageType() { return packageType; }
    public void setPackageType(String packageType) { this.packageType = packageType; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    // Метод для расчета общего веса (кофе + упаковка)
    public Double getTotalWeight() {
        return weight + (packageWeight != null ? packageWeight : 0);
    }

    // Метод для расчета цены за 1 кг
    public Double getPricePerKg() {
        return (weight != null && weight > 0 && price != null) ? price / weight : 0.0;
    }

    @Override
    public String toString() {
        return String.format("Coffee{id=%d, name='%s', type=%s, weight=%.3f, volume=%.3f, price=%.2f}",
                id, name, type, weight, volume, price);
    }
}