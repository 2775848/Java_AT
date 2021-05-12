package homework.task2;

public class Calendar1_1 {
    public static void main (String[] args) {
        String[] daysOfWeek = new String[]{
                "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
        };
        String[] months = new String[]{
                "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        };
        int date;
        int weekNumber;
        int d = 0;
        final int MAX_WEEK_NUMBER = 6;
        int[][][] calendar = new int[months.length][MAX_WEEK_NUMBER][daysOfWeek.length];
        StringBuilder str = new StringBuilder();


        for (int m = 0; m < months.length; m++) {
            date = 1;
            weekNumber = 0;
            while (date <= 30) {
                calendar[m][weekNumber][d] = date;
                date++;
                d++;
                if (d == daysOfWeek.length) {
                    d = 0;
                    weekNumber++;
                }
            }
        }


        // print matrix
        System.out.println("---------------------");
        for (int m = 0; m < months.length; m++) {
            System.out.println(months[m].toUpperCase());
            System.out.println("---------------------");
            for (int i = 0; i < 7; i++) {
                str = new StringBuilder(daysOfWeek[i]);
                for (int j = 0; j < 6; j++) {
                    if (calendar[m][j][i] == 0) {
                        str.append("   ");
                    } else {
                        str.append(String.format(" %2d", calendar[m][j][i]));
                    }
                }
                System.out.println(str.toString());
            }
            System.out.println("---------------------");


        }
    }

}
