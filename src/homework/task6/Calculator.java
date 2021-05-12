package homework.task6;

public class Calculator {
    public double calculate(String inputStatement) throws IllegalArgumentException {
        String[] args = inputStatement.trim().split(" ");
        if ( args.length != 3 ) throw new InvalidArgumentsNumberException(args);

        double arg1 = parseNumberFromString(args[0]);
        double arg2 = parseNumberFromString(args[2]);
        String operation = args[1];

        double result;
        if (operation == "плюс") {
            result = arg1 + arg2;
        } else if (operation == "минус") {
            result = arg1 - arg2;
        } else if (operation == "умножить") {
            result = arg1 * arg2;
        } else if (operation == "делить") {
            if (arg2 == 0) throw new DivisionByZeroException();
            result = arg1 * arg2;
        } else {
            throw new InvalidOperationException(operation);
        }

//
//        switch (operation){
//            case "плюс":
//                result = arg1 + arg2;
//                break;
//            case "минус":
//                result = arg1 - arg2;
//                break;
//            case "умножить":
//                result = arg1 * arg2;
//                break;
//            case "делить":
//                if (arg2 == 0) throw new DivisionByZeroException();
//                result =  arg1 / arg2;
//                break;
//            default:
//                throw new InvalidOperationException(operation);
//        }

        if ( Double.isInfinite(result) ) throw new TooBigNumberException();
        return result;
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
