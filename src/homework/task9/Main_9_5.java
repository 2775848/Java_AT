package homework.task9;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main_9_5 {
    public static void main(String[] args) {

        String[] airlines = {"Aeroflot", "S7", "Pobeda", "UralAirlines" };
        String[] flightClasses = {"Promo", "Econom", "Business"};

//        нашел как в стримах сделать рандом генерацию... жизнь уже никогда не будет прежней )))
        Supplier<Baggage> randomBaggage =
                () -> new Baggage(  airlines[new Random().nextInt(airlines.length)],
                                    flightClasses[new Random().nextInt(flightClasses.length)],
                                    new Random().nextInt(50) );

        List<Baggage> baggageList = Stream.generate(randomBaggage).limit(9).collect(Collectors.toList());

//        исходная сгенерированная коллекция
        baggageList.forEach(b -> System.out.println(b));

        System.out.println("==============================");

//        используем лямбду для сортировки по макс.багажу
        baggageList.stream()
                .sorted( (b1, b2) -> Integer.compare(b1.maxWeight, b2.maxWeight) )
                .forEach( b -> System.out.println(b));

        System.out.println("==============================");

//        используем анонимус для сортировки по сумме длин двух строк в обратном порядке
        baggageList.stream()
                .sorted(new Comparator<Baggage>() {
                    @Override
                    public int compare(Baggage b1, Baggage b2) {
                        return Integer.compare( (b2.airline.length() + b2.flightClass.length()),
                                (b1.airline.length() + b1.flightClass.length()) );
                    }
                })
                .forEach( b -> System.out.println(
                    b + String.format(" / (%s + %s = %d)", b.airline, b.flightClass, b.airline.length() + b.flightClass.length())
                ));
    }
}



