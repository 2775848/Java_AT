package homework.task7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

//Задание 7.1
//        Создать массив цветов (минимум 7 позиций).
//        Сконвертировать массив в список (ArrayList).
//        Вывести на экран весь список с помощью итератора.
//        Отсортировать список по алфавиту.
//        Заменить элементы списка на позициях 1, 3, 5 на аналогичные, но с приставкой + "Dark ".
//        Вывести на экран весь список с помощью for-each цикла.
//        Получить под-список с 1 по 5 элементы включительно.
//        Написать метод, который поменяет местами 1 и 4 элементы межды собой.
//        Получить элемент с индексом 3, сохранить в переменную а1.
//        Проверить, содержится ли объект из переменной а1 в коллекции.
//        Удалить все элементы, содержащие букву 'o'
//        Превратить список в массив.
public class Main_7_1 {
    public static void main(String[] args) {
        String[] colors = {
                "белый",
                "черный",
                "серый",
                "светло-серый",
                "темно-серый",
                "совсем темно-серый",
                "практически черный, но всё еще серый"};


        ArrayList<String> colorList = new ArrayList<>();
        Collections.addAll(colorList, colors);
        System.out.println(colorList);


        Iterator<String> iter = colorList.iterator();
        while (iter   .hasNext()){
            System.out.println(iter.next());
        }
        Collections.sort(colorList);
        System.out.println(colorList.set(0,"Dark " + colorList.get(0)) + " => " + colorList.get(0) );
        System.out.println(colorList.set(2,"Dark " + colorList.get(2)) + " => " + colorList.get(2) );
        System.out.println(colorList.set(4,"Dark " + colorList.get(4)) + " => " + colorList.get(4) );

        for (String color : colorList) {
            System.out.print(color +  "  ");
        }

        ArrayList<String> subColorList = new ArrayList<>();

        for (int i = 0; i <= 5; i++ )
            subColorList.add(colorList.get(i));
    }

}
