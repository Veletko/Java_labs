public class Main {
    public static void main(String[] args) {
        // Тестирование конструктора по умолчанию
        DynamicArray defaultArray = new DynamicArray();
        System.out.println("Default Constructor:");
        System.out.println("Capacity: " + defaultArray.getCapacity());
        System.out.println("Size: " + defaultArray.getSize());
        System.out.println("Array: [" + defaultArray.toString() + "]");

        // Тестирование конструктора с параметром
        DynamicArray customArray = new DynamicArray(5);
        System.out.println("\nCustom Constructor (capacity = 5):");
        System.out.println("Capacity: " + customArray.getCapacity());
        System.out.println("Size: " + customArray.getSize());
        System.out.println("Array: [" + customArray.toString() + "]");

        // Тестирование исключения
        try {
            DynamicArray invalidArray = new DynamicArray(0);
        } catch (IllegalArgumentException e) {
            System.out.println("\nException caught: " + e.getMessage());
        }

        // Тестирование добавления элементов и ensureCapacity
        DynamicArray testArray = new DynamicArray(2);
        testArray.add(1);
        testArray.add(2);
        System.out.println("\nTest Array after adding elements:");
        System.out.println("Capacity: " + testArray.getCapacity());
        System.out.println("Size: " + testArray.getSize());
        System.out.println("Array: [" + testArray.toString() + "]");

        // Тестирование ensureCapacity через добавление элемента
        testArray.add(3); // Это вызовет увеличение capacity
        System.out.println("\nTest Array after adding one more element:");
        System.out.println("Capacity: " + testArray.getCapacity());
        System.out.println("Size: " + testArray.getSize());
        System.out.println("Array: [" + testArray.toString() + "]");
    }
}