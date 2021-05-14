package homework.task6.exceptions;

public class TooBigNumberException extends NumberFormatException {
    @Override
    public String toString() {
        return "Слишком большое итоговое значение";
    }
}