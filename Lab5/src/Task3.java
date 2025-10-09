import java.util.Arrays;
import java.util.Comparator;

public class Task3 {

    /*
    * •	В массиве хранится n явно заданных текстовых строк. Создать метод:
•	выводящий содержимое массива в строку через пробел;
•	сортирующий массив в обратном порядке (без учета регистра) от z до a;
•	сортирующий массив по количеству слов в строке (слова разделены пробелами).
•	Программа должна вывести строки в начальном и отсортированном порядке.
*/

    // Метод для вывода массива строк в одну строку через пробел
    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    // Метод для сортировки массива в обратном порядке (без учета регистра, от z до a)
    public static String[] sortReverseIgnoreCase(String[] array) {
        String[] result = Arrays.copyOf(array, array.length); // Создаем копию массива
        Arrays.sort(result, String.CASE_INSENSITIVE_ORDER.reversed());
        return result;
    }

    // Метод для сортировки массива по количеству слов в строке
    public static String[] sortByWordCount(String[] array) {
        String[] result = Arrays.copyOf(array, array.length); // Создаем копию массива
        Arrays.sort(result, new Comparator<String>() {
            public int compare(String s1, String s2) {
                int count1 = s1.trim().isEmpty() ? 0 : s1.trim().split("\\s+").length;
                int count2 = s2.trim().isEmpty() ? 0 : s2.trim().split("\\s+").length;
                return Integer.compare(count1, count2); // Сортировка по возрастанию количества слов
            }
        });
        return result;
    }

    public static void main(String[] args) {
        String[] strings = {
                "Hello world",
                "A quick brown fox",
                "Zebra",
                "apple pie",
                "Sunny hills bloom"
        };

        // Тест 1: Вывод исходного массива
        System.out.println("Исходный массив:");
        printArray(strings);

        // Тест 2: Сортировка в обратном порядке (без учета регистра)
        System.out.println("\nМассив, отсортированный в обратном порядке (без учета регистра):");
        String[] reverseSorted = sortReverseIgnoreCase(strings);
        printArray(reverseSorted);

        // Тест 3: Сортировка по количеству слов
        System.out.println("\nМассив, отсортированный по количеству слов:");
        String[] wordCountSorted = sortByWordCount(strings);
        printArray(wordCountSorted);
    }
}