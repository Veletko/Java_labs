public class Main {
    public static void main(String[] args) {
        // Тестирование конструктора по умолчанию
        DynamicArray defaultArray = new DynamicArray();
        System.out.println("Default Constructor:");
        System.out.println("Capacity: " + defaultArray.getCapacity()); // Ожидается 10
        System.out.println("Size: " + defaultArray.getSize()); // Ожидается 0
        System.out.println("Array length: " + defaultArray.getArray().length); // Ожидается 10

        DynamicArray customArray = new DynamicArray(5);
        System.out.println("\nCustom Constructor (capacity = 5):");
        System.out.println("Capacity: " + customArray.getCapacity()); // Ожидается 5
        System.out.println("Size: " + customArray.getSize()); // Ожидается 0
        System.out.println("Array length: " + customArray.getArray().length); // Ожидается 5

        try {
            DynamicArray invalidArray = new DynamicArray(0);
        } catch (IllegalArgumentException e) {
            System.out.println("\nException caught: " + e.getMessage());
        }
    }
}