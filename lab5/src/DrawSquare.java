import java.util.Scanner;

public class DrawSquare {
    public static void main(String[] args) {
        System.out.println("Podaj długość boku kwadratu");
        int size = 0;
        try (Scanner sc = new Scanner(System.in)) {
            size = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // catch size mismatch
        if (size < 1) {
            System.err.println("Za mały rozmiar");
            System.exit(0);
        }
        // fast way out for size==1
        if (size == 1) {
            System.out.println("#");
            System.exit(0);
        }
        // top
        for (int i = 0; i < size; i++) {
            System.out.print("#");
        }
        System.out.println();
        // body
        for (int y = 1; y < size - 1; y++) {
            System.out.print("#");
            for (int j = 1; j < size - 1; j++) {
                System.out.print(" ");
            }
            System.out.print("#");
            System.out.println();

        }
        // bottom
        for (int i = 0; i < size; i++) {
            System.out.print("#");
        }
        System.out.println();
    }
}
