package lab5;

import java.util.Scanner;

public class DrawTriangle {
    public static void main(String[] args) {
        System.out.println("Podaj wysokość trójkąta");
        int height = 0;
        try (Scanner sc = new Scanner(System.in)) {
            height = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
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
        int width = 0;
        {
            Double dw = Double.valueOf(height);
            dw = 2 * dw / Math.sqrt(3);
            width = (int) Math.ceil(dw);
        }
        for (int i = 1; i <= height; i++) {
            int localWidth = 0;
            Double dw = Double.valueOf(i);
            dw = 2 * dw / Math.sqrt(3);
            localWidth = (int) Math.round(dw);
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
        System.out.println(height + " " + width);

    }
}
