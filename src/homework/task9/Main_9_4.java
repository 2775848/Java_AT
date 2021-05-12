package homework.task9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main_9_4 {

    public static void main(String[] args) {

        List<int[]> busStopsList = getRandomBusStopsList(); // получаем рандом список остановок
        // монструозный и нечитаемый редьюс, зато в одну строчку))
        int sum = busStopsList.stream().reduce(0, (subsum, busStop) -> subsum + busStop[0] - busStop[1], (acc, subsum) -> acc + subsum);
        System.out.println("Number of passengers at last stop: " + sum);

    }
    public static  List<int[]> getRandomBusStopsList(){
        final int MAX_NUMBER_OF_PASSENGERS= 50; // макс.вместимость автобуса
        final int NUMBER_OF_BUS_STOP = new Random().nextInt(10) + 5; // рандом количества остановок
        final int START_NUMBER_OF_PASSENGERS = new Random().nextInt(50); // рандом вошедших на первой остановке

        List<int[]> busStopsList = new ArrayList<>();
        busStopsList.add(new int[]{START_NUMBER_OF_PASSENGERS, 0}); // заполняем первый элемент
        System.out.println(String.format("%d) [in:%d, out:%d]", 1, START_NUMBER_OF_PASSENGERS, 0));

        int currentNumberOfPassengers = START_NUMBER_OF_PASSENGERS;
        for (int i = 2; i <= NUMBER_OF_BUS_STOP; i++) {
            int numberOfExiting = new Random().nextInt(currentNumberOfPassengers + 1);// рандом выходящих, но не более текущего количества
            currentNumberOfPassengers -= numberOfExiting;
            int numberOfIncoming = new Random().nextInt(MAX_NUMBER_OF_PASSENGERS - currentNumberOfPassengers + 1); // рандом входящих, но не более макс.вместимости - текущее количество
            currentNumberOfPassengers += numberOfIncoming;
            busStopsList.add(new int[]{numberOfIncoming, numberOfExiting});
            System.out.println(String.format("%d) [in:%d, out:%d]", i, numberOfIncoming, numberOfExiting));
        }
        return busStopsList;
    }
}
