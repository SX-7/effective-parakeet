import java.util.Calendar;

public class Weekend1 {
    public void day() {
        Calendar c = Calendar.getInstance();
        System.out.print("Dzisiaj jest ");
        switch (c.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY:
                System.out.println("Poniedziałek");
            case Calendar.TUESDAY:
                System.out.println("Wtorek");
            case Calendar.WEDNESDAY:
                System.out.println("Środa");
            case Calendar.THURSDAY:
                System.out.println("Czwartek");
            case Calendar.FRIDAY:
                System.out.println("Piątek");
            default:
                System.err.println("Weekend");
        }
    }
}
