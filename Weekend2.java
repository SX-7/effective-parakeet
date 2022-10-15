import java.util.Calendar;

public class Weekend2 {
    void print() {
        Calendar c = Calendar.getInstance();
        if (c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||c.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY) {
            System.out.println("Mamy weekend!");
            return;
        }
        //if weekend check failed we say the day
        System.out.print("Dziś ");
        switch (c.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY:
                System.out.print("poniedziałek");
            case Calendar.TUESDAY:
                System.out.print("wtorek");
            case Calendar.WEDNESDAY:
                System.out.print("środa");
            case Calendar.THURSDAY:
                System.out.print("czwartek");
            case Calendar.FRIDAY:
                System.out.print("piątek");
            default:
                break;
        }
        System.out.print(", do weekendu pozostał");
        //now we display remaining days till weekend
        switch (c.get(Calendar.DAY_OF_WEEK)){
            case Calendar.MONDAY:
                System.out.print("y 4 dni.");
            case Calendar.TUESDAY:
                System.out.print("y 3 dni.");
            case Calendar.WEDNESDAY:
                System.out.print("y 2 dni.");
            case Calendar.THURSDAY:
                System.out.print(" 1 dzień.");
            case Calendar.FRIDAY:
                System.out.print("o 0 dni.");
            default:
                break;
        }
    }
}
