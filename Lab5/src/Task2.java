public class Task2 {
    /*
    * Написать и протестировать перегруженный метод, выводящий на экран:
•	одномерный массив типа int;
•	одномерный массив типа String;
•	двухмерный массив типа int;
•	двухмерный массив типа float
*/
    // Перегруженный метод для вывода одномерного массива int
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Перегруженный метод для вывода одномерного массива String
    public static void printArray(String[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print("\"" + array[i] + "\"");
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Перегруженный метод для вывода двумерного массива int
    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%6d", array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // Перегруженный метод для вывода двумерного массива float
    public static void printArray(float[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%8.2f", array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Одномерный массив int:");
        int[] intArray = {1, 2, 3, 4, 5};
        printArray(intArray);

        System.out.println("\nОдномерный массив String:");
        String[] stringArray = {"apple", "banana", "orange"};
        printArray(stringArray);

        System.out.println("\nДвумерный массив int:");
        int[][] intMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printArray(intMatrix);

        System.out.println("\nДвумерный массив float:");
        float[][] floatMatrix = {
                {1.5f, 2.25f, 3.75f},
                {4.0f, 5.5f, 6.25f}
        };
        printArray(floatMatrix);
    }
}