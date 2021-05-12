package homework.task7;

public class Main_7_2 {
    public static void main(String[] args) {
        makeBatchOfBurgers(3);
    }

    public static void makeBatchOfBurgers(int n){
        Chief chief = new Chief();
        StringBuilder validBurgerReport = new StringBuilder();

        int burgerCounter = 0;
        int id = 0;
        while ( burgerCounter < n ) {
            id++;
            Package p = Package.generateRandom(id);
            if ( Chief.isValidPackage(p) ) {
                Burger b = chief.cookBurger(p);
                validBurgerReport.append("OK! " + b + "\n");
                burgerCounter++;
            }
        }
        System.out.println("==========");
        System.out.println(validBurgerReport);
    }
}