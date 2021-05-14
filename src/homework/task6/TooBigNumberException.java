package homework.task6;

public class TooBigNumberException extends NumberFormatException {
    @Override
    public String toString() {
        return "Слишком большое итоговое значение";
    }
}