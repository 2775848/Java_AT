package homework.task1;
public class Calc {

    public static void main(String[] args) {
        add(27, 15);
        sub(27, 15);
        mult(27, 15);
        div(27, 15);
    }
    public static void add(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a + b));
    }
    public static void sub(int a, int b){
        System.out.println(a + " - " + b + " = " + (a - b));
    }
    public static void mult(int a, int b) {
        System.out.println(a + " * " + b + " = " + (a * b));
    }
    public static void div(int a, int b) {
        System.out.println(a + " / " + b + " = " + (double)a / b);
    }
}
