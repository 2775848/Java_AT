package homework.task2;

public class Calendar2 {
    public static void main (String[] args) {
        String[] daysOfWeek = new String[] {
            "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
        };
        String[][] months = new String[][] {
                {"Jan", "31"},
                {"Feb", "28"},
                {"Mar", "31"},
                {"Apr", "30"},
                {"May", "31"},
                {"Jun", "30"},
                {"Jul", "31"},
                {"Aug", "31"},
                {"Sep", "30"},
                {"Oct", "31"},
                {"Nov", "30"},
                {"Dec", "31"}
        };
        int date;
        int monthLength;
        int d = 0;

        for(int m = 0; m < months.length; m++) {
            date = 1;
            monthLength = Integer.parseInt(months[m][1]);

            while (date <= monthLength){
                System.out.println(String.format("%s - %s - %d", months[m][0], daysOfWeek[d], date));
                date++;
                d++;
                if ( d == daysOfWeek.length) {
                    d = 0;
                }
            }
        }
    }
}
