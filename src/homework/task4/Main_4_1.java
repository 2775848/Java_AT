
import java.util.Scanner;

public class Main_4_1 {
    public static void main(String[] args) {
        double degreeInput = readDegree(); // вызываем метод для чтения ввода пользователя
        // проверяем, что ввод неотрицательный, иначе завершаем программу
        if (degreeInput < 0) {
            System.out.println("Введено некорректное значение!");
            return;
        }
        Compass compass = new Compass(); // создаем экземпляр компаса
        compass.showDirection(degreeInput); // вызываем метод для определения направления
    }
    static double readDegree(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число градусов больше 0: ");
        // если введено не числовое значение, то возвращаем -1
        return scanner.hasNextDouble() ? scanner.nextDouble() : -1;
    }
}
class Compass {
    public void showDirection(double degreeInput) {
        int directionIndex = getDirectionIndex(degreeInput);
        // округляем вниз до двух знаков после запятой, чтобы 44,99999 отражалось как 44,99, а не 45.00
        double roundDegreeInput = (int)(degreeInput * 100) / 100;
        // выводим результат с конечным форматированием
        System.out.println( String.format("%s %.2f\u00B0", Direction.values()[directionIndex], roundDegreeInput) );
    }
    public int getDirectionIndex(double degreeInput) {
        final int FULL_TURN = 360;
        double targetDegree = degreeInput % FULL_TURN; // нормализуем ввод к диапазону 0-360
        double sectorSize = FULL_TURN / Direction.values().length; // получаем размер одного сектора в градусах
        int lowerBoundIndex = (int)(targetDegree / sectorSize); // целое значение от деления ввода на размер сектора = индекс нижней границы сектора
        int upperBoundIndex = (lowerBoundIndex + 1) % Direction.values().length; // индекс верхней границы сектора
        double lowerBound = Direction.values()[lowerBoundIndex].getDegreeFromEnum(); // получаем из enum  нижнюю границу в градусах
        System.out.println(Direction.values()[1].degree);
        // если разница между вводом и нижней границей меньше половины сектора, то возвращаем индекс нижней границы, иначе верхней
        return (targetDegree - lowerBound < sectorSize / 2) ? lowerBoundIndex : upperBoundIndex;
    }
}
enum Direction {
    NORTH("N", "North",0),
    NORTH_EAST("NE", "North-East",45),
    EAST("E", "East",90),
    SOUTH_EAST("SE", "South-East",135),
    SOUTH("S", "South", 180),
    SOUTH_WEST("SW", "South-West", 225),
    WEST("W","West", 270),
    NORTH_WEST("NW","North-West", 315);

    public final String shortName;
    public final String name;
    public final int degree;

    Direction(String shortName, String name, int degree) {
        this.name = name;
        this.shortName = shortName;
        this.degree = degree;
    }
    public int getDegreeFromEnum(){
        return this.degree;
    }
    @Override
    public String toString() {
        return  String.format("[%s] - %s -", shortName, name );
    }
}


