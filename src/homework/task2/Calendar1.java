package homework.task2;


public class Calendar1 {
    public static void main (String[] args) {
        String[] daysOfWeek = new String[] {
            "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
        };
        String[] months = new String[] {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        };
        int date;
        int d = 0;

        for(int m = 0; m < months.length; m++) {
            date = 1;
            while (date <= 30){
                System.out.println(String.format("%s - %s - %d", months[m], daysOfWeek[d], date));
                date++;
                d++;
                if ( d == daysOfWeek.length) {
                    d = 0;
                }
            }
        }
    }
}
