package homework.task6;


import java.util.function.BiFunction;

public enum Operation {
    ПЛЮС( (o1, o2) -> (double)o1 + (double)o2 ),
    МИНУС( (o1, o2) -> (double)o1 - (double)o2),
    УМНОЖИТЬ( (o1, o2) -> (double)o1 * (double)o2),
    ДЕЛИТЬ( (o1, o2) -> {
            if ((double)o2 == 0) throw new DivisionByZeroException();
            return (double)o1 / (double)o2;
    });

    private BiFunction func;

    public BiFunction getFunc() {
        return func;
    }

    Operation(BiFunction func) {
        this.func = func;
    }

}