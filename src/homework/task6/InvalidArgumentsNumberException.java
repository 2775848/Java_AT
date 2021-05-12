package homework.task6;

import java.util.Arrays;

public class InvalidArgumentsNumberException extends IllegalArgumentException {
    private String[] args;
    public InvalidArgumentsNumberException (String[] args) {
        super();
        this.args = args;
    }
    @Override
    public String toString() {
        return "Неверный формат выражения (разделителей: " + (args.length-1) + ")\n"
                + "Выражение разделено на следующие части: " + Arrays.toString(args);
    }
}
class InvalidOperationException extends IllegalArgumentException {
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

class DivisionByZeroException extends IllegalArgumentException {
    @Override
    public String toString() {
        return "Деление на ноль";
    }
}

class InvalidNumberException extends NumberFormatException {
    private String argument;
    public InvalidNumberException (String argument) {
        super();
        this.argument = argument;
    }
    @Override
    public String toString() {
        return "Аргумент слишком большой или не является числом: \'" + this.argument + "\'" ;
    }
}

class TooBigNumberException extends NumberFormatException {
    @Override
    public String toString() {
        return "Слишком большое итоговое значение";
    }
}