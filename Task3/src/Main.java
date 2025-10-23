public class Main {
    public static void main(String[] args) {
        // Тестирование конструкторов
        MyArrayList array = new MyArrayList(3);
        System.out.println("Initial: Size=" + array.getSize() + ", Capacity=" + array.getCapacity() + ", Array=[" + array + "]");

        // Тестирование pushBack
        array.pushBack(1);
        array.pushBack(2);
        array.pushBack(3);
        System.out.println("After pushBack(1,2,3): [" + array + "], Size=" + array.getSize() + ", Capacity=" + array.getCapacity());
        array.pushBack(4); // Увеличение capacity
        System.out.println("After pushBack(4): [" + array + "], Size=" + array.getSize() + ", Capacity=" + array.getCapacity());

        // Тестирование pushFront
        array.pushFront(0);
        System.out.println("After pushFront(0): [" + array + "]");

        // Тестирование insert
        array.insert(2, 10);
        System.out.println("After insert(2, 10): [" + array + "]");

        // Тестирование popFront
        Integer front = array.popFront();
        System.out.println("PopFront: " + front + ", Array=[" + array + "]");

        // Тестирование popBack
        Integer back = array.popBack();
        System.out.println("PopBack: " + back + ", Array=[" + array + "]");

        // Тестирование removeAt
        Integer removed = array.removeAt(1);
        System.out.println("RemoveAt(1): " + removed + ", Array=[" + array + "]");

        // Тестирование remove
        array.pushBack(2);
        System.out.println("After pushBack(2): [" + array + "]");
        boolean removedOne = array.remove(2);
        System.out.println("Remove(2): " + removedOne + ", Array=[" + array + "]");

        // Тестирование removeAll
        array.pushBack(1);
        array.pushBack(1);
        System.out.println("After pushBack(1,1): [" + array + "]");
        int removedCount = array.removeAll(1);
        System.out.println("RemoveAll(1): " + removedCount + ", Array=[" + array + "]");

        // Тестирование clear
        array.pushBack(5);
        array.pushBack(6);
        System.out.println("Before clear: [" + array + "]");
        array.clear();
        System.out.println("After clear: [" + array + "], Size=" + array.getSize());

        // Тестирование reverse
        array.pushBack(1);
        array.pushBack(2);
        array.pushBack(3);
        System.out.println("Before reverse: [" + array + "]");
        array.reverse();
        System.out.println("After reverse: [" + array + "]");

        // Тестирование shuffle
        array.pushBack(4);
        System.out.println("Before shuffle: [" + array + "]");
        array.shuffle();
        System.out.println("After shuffle: [" + array + "]");

        // Тестирование equals
        MyArrayList array2 = new MyArrayList();
        array2.pushBack(3);
        array2.pushBack(2);
        array2.pushBack(1);
        array2.pushBack(4);
        System.out.println("Array2: [" + array2 + "]");
        System.out.println("Equals (array, array2): " + array.equals(array2));

        // Тестирование getElementAt
        Integer element = array.getElementAt(2);
        System.out.println("GetElementAt(2): " + element);

        // Тестирование clone
        MyArrayList clonedArray = array.clone();
        System.out.println("Cloned array: [" + clonedArray + "], Size=" + clonedArray.getSize() + ", Capacity=" + clonedArray.getCapacity());
        System.out.println("Equals (array, clonedArray): " + array.equals(clonedArray));

        // Тестирование исключений
        try {
            array.getElementAt(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        try {
            array.popFront();
            array.popFront();
            array.popFront();
            array.popFront();
            array.popFront();
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}