import java.util.List;

public interface CalculatorRegistry {
    double performOperation(double a, double b, String operator);
    void saveOperation(double a, double b, String operator, double result);
    List<Operation> getHistory();
}