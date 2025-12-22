package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "coffee")
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CoffeeType type;

    @Column(nullable = false)
    private Double weight;

    private Double volume;

    @Column(nullable = false)
    private Double price;

    private Double packageWeight;
    private String packageType;

    @Column(nullable = false)
    private Integer quantity = 0;

    // Конструкторы
    public Coffee() {}

    public Coffee(String name, CoffeeType type, Double weight, Double price, Integer quantity) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.price = price;
        this.quantity = quantity;
    }

    // Геттеры и сеттеры
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public CoffeeType getType() { return type; }
    public void setType(CoffeeType type) { this.type = type; }

    public Double getWeight() { return weight != null ? weight : 0.0; }
    public void setWeight(Double weight) { this.weight = weight; }

    public Double getVolume() { return volume; }
    public void setVolume(Double volume) { this.volume = volume; }

    public Double getPrice() { return price != null ? price : 0.0; }
    public void setPrice(Double price) { this.price = price; }

    public Double getPackageWeight() { return packageWeight; }
    public void setPackageWeight(Double packageWeight) { this.packageWeight = packageWeight; }

    public String getPackageType() { return packageType; }
    public void setPackageType(String packageType) { this.packageType = packageType; }

    public Integer getQuantity() { return quantity != null ? quantity : 0; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    // Enum
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

    // Расчитанные поля
    @Transient
    public Double getTotalWeight() {
        return getWeight() + (packageWeight != null ? packageWeight : 0);
    }

    @Transient
    public Double getPricePerKg() {
        return (getWeight() > 0 && getPrice() > 0) ? getPrice() / getWeight() : 0.0;
    }

    // Удобный метод для отладки
    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", weight=" + weight +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}