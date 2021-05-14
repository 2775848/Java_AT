package homework.task6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    public double calculate(String inputStatement) throws IllegalArgumentException {

        List<String> args = parseArgsToList(inputStatement); // разбираем входящее выражение на части, чистим и собираем в список аргументов
        if ( args.size() != 3 ) throw new InvalidNumberOfArgumentsException(args); // если не 3 элемента, то InvalidNumberOfArgumentsException
        double arg1 = parseNumberFromString(args.get(0)); // парсим 1-й аргумент
        double arg2 = parseNumberFromString(args.get(2)); // парсим 2-й аргумент
        Operation operation = parseOperationFromString(args.get(1)); // находим в ENUM нужную операцию
        double result = (double) operation.getFunc().apply(arg1, arg2); // получаем из ENUM функцию и применяем к аргументам
        if ( Double.isInfinite(result) ) throw new TooBigNumberException(); // если результат больше double, то кидаем TooBigNumberException

        return result;
    }

    List<String> parseArgsToList(String inputStatement){
        return Arrays.stream(inputStatement.split(" ")) // делим на части по пробелу
                .filter(s -> ! s.equals("")) // удаляем пустые элементы
                .collect(Collectors.toList()); // и собираем в список
    }

    Operation parseOperationFromString(String str) throws InvalidOperationException {
        for (Operation operation: Operation.values()) { // перебираем все операции в ENUM
            if ( str.equalsIgnoreCase(operation.name()) ) return operation; // если входящая строка равна названию операции, то возвращаем эту операцию
        }
        throw new InvalidOperationException(str); // если ничего не нашли, кидаем InvalidOperationException
    }

    Double parseNumberFromString(String str) throws InvalidNumberException {
        try {
            if ( Double.isInfinite(Double.parseDouble(str)) ) throw new InvalidNumberException(str);
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException(str);
        }
    }

}
