package homework.task6;
import java.util.Scanner;

public class Main_6_1 {
    public static void main(String[] args) {
//        String inputStatement = "5 плюс 23";
//        String inputStatement = "25 минус 7";
//        String inputStatement = "5 умножить 3";
//        String inputStatement = "5 делить 3";
//        String inputStatement = "5 делить 0";
//        String inputStatement = "54df dfg 2";
//        String inputStatement = "10 dfg 5";
//        String inputStatement = "9234630430943563333333333333333333333333333333333347498543056094358834596895723345634975304759769345734058304" +
//                "85072357634573495734956349758964545876559237349072836345863495723879420857357985399438779475043795048095059" +
//                "873475698375642965482946752894567860596702760475048059432345438579048759023875092745872034579 минус 1";
//        String inputStatement = "23463043085072357634573495734956349758964545876559237349072836345863495723879420857357985399438779475043" +
//                "795048095059873475698375642965482946752894567860596702760475048059432345438579048759023875092745872034579 умножить " +
//                "100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        String inputStatement = readString("Введите строку в формате \"аргумент1 арифметическаяОперация аргумент2\" :");
        Calculator calc = new Calculator();
        try {
            System.out.println( inputStatement + " = " + calc.calculate(inputStatement) );
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static String readString(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.nextLine();
    }
}


