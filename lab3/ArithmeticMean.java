package lab3;
public class ArithmeticMean {
    public static void main(String[] args) {
        if (args.length == 0)
        {
            System.out.println("Brak argumentów programu.");
        }
        else
        {
            System.out.print("Średnia arytmetyczna liczb: ");
            int a = 0;
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]+", ");
                a=a+Integer.parseInt(args[i]);
            }
            float res=(float)a/args.length;
            System.out.print("wynosi "+res);
        }
    }
}

