public class FloatArithmeticMean {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Brak argumentów programu.");
            System.exit(0);
        }
        float a = 0;
        for (int i = 0; i < args.length; i++) {
            System.out.printf("%10.3f%n", Float.parseFloat(args[i]));
            a = a + Float.parseFloat(args[i]);
        }
        System.out.println("----------");
        System.out.printf("%10.3f%n", a);
        float res = a / args.length;
        System.out.printf("Średnia arytmetyczna: %.4f%n", res);
    }
}
