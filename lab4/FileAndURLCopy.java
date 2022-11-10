package lab4;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class FileAndURLCopy {
    public static void main(String[] args) {
        // basic check
        if (args.length == 0) {
            System.out.println("Brak argumentów programu.");
            System.out.println("Użycie: java FileCopy source_file target");
            System.exit(0);
        }
        // the operation

        if(args.length==1){
            try {
                URL url = new URL(args[0]);
                try (InputStream in = url.openStream()) {
                    Files.copy(in, Path.of(args[0].split(File.separator, 0)[args[0].split(File.separator, 0).length - 1]));
                } catch (UnknownHostException e) {
                    System.err.println("Nieznany host "+ args[0]);
                } catch (Exception e) {
                    System.err.println("Inny błąd pobierania");
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                System.err.println("Nie istnieje taki url");
                System.exit(0);
            }            
        }

        try {
            if (Files.isDirectory(Path.of(args[1]))) {
                args[1] = args[1] + args[0].split(File.separator, 0)[args[0].split(File.separator, 0).length - 1];
            }
            if (Files.exists(Path.of(args[1]))) {
                System.err.println(args[1] + " już istnieje");
                throw new Exception(args[1] + " już istnieje");
            }
            //run a check and do a url copy if it's a url, otherwise do a file one
            if (Files.isDirectory(Path.of(args[0]))) {
                System.err.println(args[0] + " jest folderem");
                throw new Exception(args[0] + " jest folderem");
            }
            Files.copy(Path.of(args[0]), Path.of(args[1]));
        } catch (NoSuchFileException e) {
            System.err.println("Plik " + args[0] + " nie istnieje.");
        } catch (AccessDeniedException e) {
            System.err.println("Brak uprawnień dostępu");
        } catch (IOException e) {
            System.err.println("Inny błąd wejścia");
            e.printStackTrace();
        } catch (Exception e) {

        }
    }
}
