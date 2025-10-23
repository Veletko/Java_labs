import java.time.LocalDateTime;

public class Operation {
    private final double operand1;
    private final double operand2;
    private final String operator;
    private final double result;
    private final LocalDateTime timestamp;

    public Operation(double operand1, double operand2, String operator, double result) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
        this.result = result;
        this.timestamp = LocalDateTime.now();
    }

    public double getOperand1() { return operand1; }
    public double getOperand2() { return operand2; }
    public String getOperator() { return operator; }
    public double getResult() { return result; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return String.format("%s %s %s = %s (%s)", operand1, operator, operand2, result, timestamp);
    }
}