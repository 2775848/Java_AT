package homework.task11;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

public class Main_11_1 {
    public static void main(String[] args) {
        Casino casino = new Casino();
        Arrays.stream(casino.getClass().getDeclaredMethods())
                .filter( m -> Arrays.stream(m.getDeclaredAnnotations())
                        .filter(a -> (a instanceof Gamble))
                        .anyMatch(a -> ((Gamble) a).testRun())
                )
                .forEach( m -> {
                    try {
                        m.setAccessible(true);
                        m.invoke(casino);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
    }
}

