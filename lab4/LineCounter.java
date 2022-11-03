package lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineCounter {
    public static void main(String[] args) {
        if (args.length==0) {
            System.out.println("Brak argumentów programu.");
            System.exit(0);
        }
        long lines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            while(br.readLine()!=null) lines++;
        } catch (IOException e) {
            e.printStackTrace();
            //TODO: better exception handling
        }    
        System.out.println("Liczba wierszy w pliku "+args[0]+" wynosi: "+lines);
    }
}
