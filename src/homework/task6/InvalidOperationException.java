package homework.task6;

public class InvalidOperationException extends IllegalArgumentException {
    private String operation;
    public InvalidOperationException (String operation) {
        super();
        this.operation = operation;
    }
    @Override
    public String toString() {
        return "Неизвестная арифметическая операция: \'" + operation + "\'";
    }
}