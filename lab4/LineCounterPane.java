package lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class LineCounterPane {
    public static void main(String[] args) {
        String inputValue = JOptionPane.showInputDialog("Please input a filename");

        long lines = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(inputValue))) {
            while (br.readLine() != null)
                lines++;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            // TODO: better exception handling
        }

        JOptionPane.showMessageDialog(null, "Liczba wierszy w pliku " + inputValue + " wynosi: " + lines, "Wynik", JOptionPane.PLAIN_MESSAGE);
    }
}
