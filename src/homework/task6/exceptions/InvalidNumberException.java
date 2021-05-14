package homework.task6.exceptions;

public class InvalidNumberException extends NumberFormatException {
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