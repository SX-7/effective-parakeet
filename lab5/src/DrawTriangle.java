import java.util.Scanner;

public class DrawTriangle {
    public static void main(String[] args) {
        System.out.println("Podaj wysokość trójkąta");
        int height = 0;
        try (Scanner sc = new Scanner(System.in)) {
            height = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.err.println("Błędne dane wejściowe");
            System.exit(0);
        }
        // catch height mismatch
        if (height < 1) {
            System.err.println("Za mały rozmiar");
            System.exit(0);
        }
        // fast way out for height==1
        if (height == 1) {
            System.out.println("#");
            System.exit(0);
        }
        int width = (height*2)-1;
        for (int i = 1; i <= height; i++) {
            int localWidth = (i*2)-1;
            // prefix empty/blank spaces
            for (int j = 0; j < Double.valueOf(width - localWidth) / 2; j++) {
                System.out.print(" ");
            }
            // print the triangle part
            for (int j = 0; j < localWidth; j++) {
                System.out.print("#");
            }
            // new line
            System.out.println();
        }
        //System.out.println(height + " " + width);

    }
}
