package lab4;

import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class FileCopy {
    public static void main(String[] args) {
        // basic check
        if (args.length == 0) {
            System.out.println("Brak argumentów programu.");
            System.out.println("Użycie: java FileCopy source_file target");
            System.exit(0);
        }
        // the operation
        try {
            if (Files.isDirectory(Path.of(args[1]))) {
                args[1] = args[1] + args[0].split(File.separator, 0)[args[0].split(File.separator, 0).length - 1];
            }
            if (Files.isDirectory(Path.of(args[0]))) {
                System.err.println(args[0]+" jest folderem");
                throw new Exception(args[0]+" jest folderem");
            }
            if (Files.exists(Path.of(args[1]))) {
                System.err.println(args[1]+" już istnieje");
                throw new Exception(args[1]+" już istnieje");
            }
            Files.copy(Path.of(args[0]), Path.of(args[1]));
        } catch (NoSuchFileException e) {
            System.err.println("Plik " + args[0] + " nie istnieje.");
        } catch (AccessDeniedException e) {
            System.err.println("Brak uprawnień dostępu");
        } catch (IOException e) {
            System.err.println("Inny błąd wejścia");
            e.printStackTrace();
        } catch (Exception e){
            
        }
    }
}
