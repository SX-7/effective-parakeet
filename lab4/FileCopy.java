package lab4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
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
            if (!Files.exists(Path.of(args[0]))) {
                throw new FileNotFoundException("Plik " + args[0] + " nie istnieje.");
            }
            if (!Files.isRegularFile(Path.of(args[0]))) {
                throw new FileNotFoundException(args[0] + " nie jest plikiem.");
            }
            Files.copy(Path.of(args[0]), Path.of(args[1]));
        } catch (FileAlreadyExistsException e) {
            System.err.println("Plik "+args[1]+" już istnieje.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
