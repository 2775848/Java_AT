package homework.task6.exceptions;
import java.util.List;

public class InvalidNumberOfArgumentsException extends IllegalArgumentException {
    private List<String> args;
    public InvalidNumberOfArgumentsException(List<String> args) {
        super();
        this.args = args;
    }
    @Override
    public String toString() {
        return "Неверный формат выражения\n"
                + "Выражение разделено на следующие части: " + args;
    }
}
