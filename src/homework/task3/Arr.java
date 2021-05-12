package homework.task3;

import java.util.Random;

public class Arr {
    public static void main(String[] args) {

        final int MAX_ARRAY_SIZE = 50;
        final int MAX_NUMBER = 100;
        Random r = new Random();
        int[] randomNumbers = new int[r.nextInt(MAX_ARRAY_SIZE) + 1];
        StringBuilder even = new StringBuilder("Even numbers:");
        StringBuilder odd = new StringBuilder("Odd numbers:");
        StringBuilder multipleOfThree = new StringBuilder("Numbers multiples of three:");


        for (int elem: randomNumbers){
            // заполняем элемент произвольным значением, чтоб самому не придумывать числа
            elem = r.nextInt(MAX_NUMBER);

            // добавляем элемент в StringBuilder
            if (elem % 2 == 0 || elem == 0 ){
                even.append(" " + elem);
            } else {
                odd.append(" " + elem);
            }
            if (elem % 3 == 0 && elem != 0){
                multipleOfThree.append(" " + elem);
            }
        }
        System.out.println(String.format("%s\n%s\n%s",even.toString(), odd.toString(), multipleOfThree.toString() ));
    }
}
