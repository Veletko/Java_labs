public class Main {
    public static void main(String[] args) {
        // Создание массива для тестов
        MyArrayList array = new MyArrayList(3);
        array.pushBack(1);
        array.pushBack(2);
        array.pushBack(3);
        System.out.println("Initial array: [" + array + "]");

        // Тестирование reverse
        array.reverse();
        System.out.println("After reverse: [" + array + "]");

        // Тестирование shuffle
        array.shuffle();
        System.out.println("After shuffle: [" + array + "]");

        // Тестирование equals
        MyArrayList array2 = new MyArrayList();
        array2.pushBack(3);
        array2.pushBack(2);
        array2.pushBack(1);
        System.out.println("Array2: [" + array2 + "]");
        System.out.println("Equals (array, array2): " + array.equals(array2));

        // Тестирование getElementAt
        try {
            Integer element = array.getElementAt(1);
            System.out.println("GetElementAt(1): " + element);
            array.getElementAt(5); // Проверка исключения
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Тестирование clone
        MyArrayList clonedArray = array.clone();
        System.out.println("Cloned array: [" + clonedArray + "], Size=" + clonedArray.getSize() + ", Capacity=" + clonedArray.getCapacity());
        System.out.println("Equals (array, clonedArray): " + array.equals(clonedArray));

        // Дополнительно: проверка, что клон независим
        clonedArray.pushBack(4);
        System.out.println("After pushBack(4) to clone: Original=[" + array + "], Clone=[" + clonedArray + "]");
    }
}