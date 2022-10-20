package lab2;

import java.util.Calendar;

public class Weekend {
    public void howMuchTill() {
        Calendar cd = Calendar.getInstance();
        int day = cd.get(Calendar.DAY_OF_WEEK);
        if (day > 0 && day < 6) {
            day = day - 5;
            day = Math.abs(day);
            System.out.println("Liczba dni do weekendu: " + day);
        } else {
            System.out.println("Jest weekend");
        }
    }
}
