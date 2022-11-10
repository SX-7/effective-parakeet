package lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {
    public static void main(String[] args) {
        String file = new String();
        Boolean lin = false;
        Boolean wor = false;
        Boolean cha = false;
        if (args.length == 0) {
            System.out.println("Brak argumentów programu.");
            System.exit(0);
        } else {
            // Krok 1 - znajdź pierwszą nie-opcję, ustaw jako plik
            for (String ar : args) {
                if (!(ar.charAt(0) == '-')) {
                    if (file.isEmpty()) {
                        file = ar;
                    } else {
                        System.err.println("Niepoprawna ilość argumentów nieopcjonalnych");
                        System.exit(0);
                    }
                } else {
                    // Dla innych argumentów, sprawdź czy są to odpowiednie argumenty i ustaw flagi
                    String ins = new String(ar.substring(1));
                    char chins[] = ins.toCharArray();
                    for (char ch : chins) {
                        switch (ch) {
                            case 'l':
                                lin = true;
                                break;
                            case 'w':
                                wor = true;
                                break;
                            case 'c':
                                cha = true;
                                break;
                            default:
                                System.err.println("Błędne argumenty opcjonalne");
                                System.exit(0);
                                break;
                        }
                    }
                }
            }
        }
        // Fallback dla braku opcji
        if (!(lin & wor & cha)) {
            lin = true;
            wor = true;
            cha = true;
        }

        long lines = 0;
        long words = 0;
        long chars = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String curr = null;
            while (true) {
                curr = br.readLine();
                if (curr == null) {
                    break;
                }
                lines += 1;
                words += curr.split(" ").length;
                chars += curr.replaceAll("\\s", "").length();
            }
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: better exception handling
        }
        // get results
        if (lin) {
            System.out.println("Wierszy: "+lines);
        }
        if (wor) {
            System.out.println("Słów: "+words);
        }
        if (cha) {
            System.out.println("Znaków: "+chars);
        }
    }
}
