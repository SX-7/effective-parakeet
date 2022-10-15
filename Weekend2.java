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
                System.out.println("poniedziałek");
            case Calendar.TUESDAY:
                System.out.println("wtorek");
            case Calendar.WEDNESDAY:
                System.out.println("środa");
            case Calendar.THURSDAY:
                System.out.println("czwartek");
            case Calendar.FRIDAY:
                System.out.println("piątek");
            default:
                System.err.println("weekend");
        }
    }
}
