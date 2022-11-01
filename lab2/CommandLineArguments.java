package lab2;

public class CommandLineArguments {
    public static void parse(String[] args) {
        System.out.println("Liczba argumentów: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println((i + 1) + ". " + args[i]);
        }
    }
}
