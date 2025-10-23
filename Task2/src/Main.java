import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        InventorySystem system = new InventorySystem();

        // Пример заполнения накладных
        Map<String, Integer> items1 = new HashMap<>();
        items1.put("Laptop", 5);
        Invoice invoice1 = new Invoice("Supplier1", "W1", "Delivery from Supplier1", 5000, items1);
        system.addInvoice(invoice1);

        Map<String, Integer> items2 = new HashMap<>();
        items2.put("Mouse", 10);
        Invoice invoice2 = new Invoice("W1", "W2", "Transfer between warehouses", 1000, items2);
        system.addInvoice(invoice2);

        // Вывод списка всех товаров
        System.out.println("Все товары на складах: " + system.getAllItems());

        // Вывод списка всех внешних поставщиков
        System.out.println("Внешние поставщики: " + system.getAllSuppliers());

        // Поиск товара по наименованию
        System.out.println("Поиск товара 'Laptop': " + system.findItemByName("Laptop"));
        System.out.println("Поиск товара 'Mouse': " + system.findItemByName("Mouse"));
    }
}