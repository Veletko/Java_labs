import java.util.List;
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Выполнение операций
        try {
            double result1 = calculator.performOperation(10, 5, "+");
            System.out.println("Результат: " + result1); // 15.0

            double result2 = calculator.performOperation(20, 4, "/");
            System.out.println("Результат: " + result2); // 5.0

            double result3 = calculator.performOperation(10, 0, "/");
            System.out.println("Результат: " + result3); // Выбросит исключение
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Вывод истории
        System.out.println("\nИстория операций:");
        List<Operation> history = calculator.getHistory();
        for (Operation op : history) {
            System.out.println(op);
        }
    }
}