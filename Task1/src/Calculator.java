import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Calculator implements CalculatorRegistry {
    private final List<Operation> history;
    private final String filePath = "calculator_history.txt";

    public Calculator() {
        this.history = new ArrayList<>();
        loadHistory();
    }

    @Override
    public double performOperation(double a, double b, String operator) {
        double result = 0;
        switch (operator) {
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "*": result = a * b; break;
            case "/":
                if (b == 0) throw new ArithmeticException("Деление на ноль!");
                result = a / b;
                break;
            default: throw new IllegalArgumentException("Недопустимый оператор!");
        }
        saveOperation(a, b, operator, result);
        return result;
    }

    @Override
    public void saveOperation(double a, double b, String operator, double result) {
        Operation operation = new Operation(a, b, operator, result);
        history.add(operation);
        saveToFile(operation);
    }

    @Override
    public List<Operation> getHistory() {
        return new ArrayList<>(history);
    }

    private void saveToFile(Operation operation) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(operation.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    private void loadHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Загружено из файла: " + line);
            }
        } catch (IOException e) {

        }
    }
}