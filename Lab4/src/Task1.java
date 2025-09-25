import java.util.Scanner;
import java.util.ArrayList;

public class Task1 {
    /*
    * Ввести с клавиатуры строку текста, а затем один
    *  символ. Показать на консоль индексы и количество
    *  совпадений (ищем вхождения символа в строку).
    *  В случае если совпадений не найдено, вывести
    * соответствующий текст.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод строки и символа
        System.out.print("Введите строку текста: ");
        String text = scanner.nextLine();
        System.out.print("Введите символ: ");
        String symbol = scanner.nextLine();

        // Проверка, что введен ровно один символ
        if (symbol.length() != 1) {
            System.out.println("Ошибка: необходимо ввести ровно один символ");
        } else {
            char ch = symbol.charAt(0);
            int count = 0;
            ArrayList<Integer> indexes = new ArrayList<>();

            // Подсчет совпадений и сбор индексов
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ch) {
                    count++;
                    indexes.add(i);
                }
            }

            // Вывод результатов
            if (count == 0) {
                System.out.println("Символ '" + ch + "' не найден в строке");
            } else {
                System.out.println("Количество совпадений: " + count);
                System.out.println("Индексы: " + indexes);
            }
        }

        scanner.close();
    }
}