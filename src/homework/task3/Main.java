package homework.task3;


public class Main {
    public static void main(String[] args) {
        Safe s = new Safe();
        s.f1 = 1; // public видно всем
        s.f2 = 2; // protected видно наследникам, внутри пакета и внутри класса
        //s.f3 = 3; // private видно только внутри класса => из Main не видно
        s.f4 =4; // default видно внутри пакета и внутри класса
        System.out.println(s.f1 + " " + s.f2 + " " + s.f4);
    }
}
class Safe {
    int f1;
    protected int f2;
    private int f3;
    int f4;
}