package homework.task6;


import java.util.function.BiFunction;

public enum Operation {
    ПЛЮС( (o1, o2) -> o1 + o2 ),
    МИНУС( (o1, o2) -> o1 - o2 ),
    УМНОЖИТЬ( (o1, o2) -> o1 * o2 ),
    ДЕЛИТЬ( (o1, o2) -> {
            if (o2 == 0) throw new DivisionByZeroException();
            return o1 / o2;
    });

    private final BiFunction<Double, Double, Double> func;

    public BiFunction<Double, Double, Double> getFunc() {
        return func;
    }

    Operation(BiFunction<Double, Double, Double> func) {
        this.func = func;
    }

}