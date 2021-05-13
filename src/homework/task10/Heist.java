//package ru.devray.day10.task2;
package homework.task10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;


/**
 * Задача 10.2. Форт Нокс
 * Вы - хакер, волк-одиночка, рыцарь цифрового мира, и в свободное от взлома пентагона время
 * вам пришла новая задача - разграбить федеральное хранилище, избавив толстосумов от залежей желтого металла.
 * Вы должны получить все значения полей федерального хранилища, сохранить эту информацию,
 * установить федеральному хранилищу для всех полей нулевые или пустые значения,
 * и только после этого (!!!) создать собственное хранилище (с помощью приватного конструктора
 * класса Vault) используя награбленные данные в качестве параметров.
 *
 * Т.е. по сути перенести данные из федерального хранилища в свое.
 */
public class Heist {
    public static void main(String[] args) {

        Vault federalVault = new Vault();
        // ???
        try {

//            Выводим на экран все конструкторы
            System.out.println("Конструкторы:\n====================");
            Constructor[] constructors = federalVault.getClass().getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }
//            Выводим на экран значения
            System.out.println("====================\nИсходные значения:");
            printVault(federalVault);
//            Сохраняем значения полей в переменные и обнуляем в объекте
            int dollars = (int) getAndClearPrivateFieldData(federalVault,"dollars" );
            int euros = (int) getAndClearPrivateFieldData(federalVault,"euros" );
            double tonsOfGold = (double) getAndClearPrivateFieldData(federalVault,"tonsOfGold" );
            String pentagonNukesCodes = (String) getAndClearPrivateFieldData(federalVault,"pentagonNukesCodes");

//            Выводим на экран обнуленные значения
            System.out.println("Новые значения:");
            printVault(federalVault);

//            Создаем новое хранилище через приватный конструктор
            Constructor privateConstructor = federalVault.getClass().getDeclaredConstructor(int.class, int.class, double.class, String.class);
            privateConstructor.setAccessible(true);
            Vault myCopyOfFederalVault = (Vault) privateConstructor.newInstance(dollars, euros, tonsOfGold, pentagonNukesCodes);
            System.out.println("====================");

//            Выводим на экран значения из нового хранилища
            System.out.println("Моя копия хранилища:");
            printVault(myCopyOfFederalVault);

        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        //PROFIT!
    }

//    Метод возращает и обнуляет значения полей хранилища
    public static Object getAndClearPrivateFieldData(Vault vault, String fieldName) throws IllegalAccessException, NoSuchFieldException {
        Field f = vault.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        Object fieldData = f.get(vault);
        if (fieldData instanceof Number) {
            f.set(vault, 0);
        } else if (fieldData instanceof String) {
            f.set(vault, "empty");
        } else {
            f.set(vault, null);
        }
        return fieldData;
    }

//    Метод выводит на экран значения полей хранилища
    public static void printVault(Vault vault) throws IllegalAccessException {
        if ( vault == null ) return;
        System.out.println("====================");
        Field[] allVaultFields = vault.getClass().getDeclaredFields();
        for (Field f : allVaultFields) {
            f.setAccessible(true);
            System.out.println( f.getName() + " = " + f.get(vault) );
        }
        System.out.println("====================");
    }
}
