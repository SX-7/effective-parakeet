package lab3;

public class ArithmeticMean {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Brak argumentów programu.");
            System.exit(0);
        }
        String out_str = "";
        out_str = out_str.concat("Średnia arytmetyczna liczb: ");
        int a = 0;
        for (int i = 0; i < args.length; i++) {
            out_str = out_str.concat(args[i] + ", ");
            a = a + Integer.parseInt(args[i]);
        }
        out_str = out_str.substring(0, out_str.length() - 2);
        int res = a / args.length;
        int mod = a % args.length;
        out_str = out_str.concat(" wynosi " + res);
        if (!(mod == 0))
            out_str = out_str.concat(", reszta: " + mod);
        System.out.println(out_str);
    }
}
