import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        String configFilePath = new String("lab5/config.properties");
        Properties props = new Properties();
        // Step 1: test if a file already exists
        // Step 2T: if it does, load the file with loadfromxml
        // Step 2F: if it doesn't, create, load and store defaults
        // Step 3: simple read loop with scoring system
        try {
            File propsFile = new File(configFilePath);
            // Try to create file
            if (propsFile.createNewFile()) {
                // It didn't exist! we should try writing default properties to it
                props.setProperty("wartość_minimum", "1");
                props.setProperty("wartość_maximum", "10");
                props.setProperty("procent", "70");
                props.setProperty("powtórzeń_minimum", "10");
                props.setProperty("powtórzeń_maximum", "25");
                try (OutputStream os = new FileOutputStream(propsFile)) {
                    props.storeToXML(os, null);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }

            } else {
                try (InputStream is = new FileInputStream(propsFile)) {
                    props.loadFromXML(is);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
            // Panic!
        }
        // At this point we have proper properties in props, time to move them to local
        // vars
        double percent = Double.parseDouble(props.getProperty("procent"));
        int minVal = Integer.parseInt(props.getProperty("wartość_minimum"));
        int maxVal = Integer.parseInt(props.getProperty("wartość_maximum"));
        int minRep = Integer.parseInt(props.getProperty("powtórzeń_minimum"));
        int maxRep = Integer.parseInt(props.getProperty("powtórzeń_maximum"));
        // randomly select two numbers within boundaries
        Random random = new Random();
        random.setSeed(System.nanoTime());
        int right = 0;
        int wrong = 0;
        int val1 = 0;
        int val2 = 0;
        int res = 0;
        Scanner sc = new Scanner(System.in);
        // store them
        for (int i = 0; i < maxRep; i++) {
            val1 = random.nextInt(minVal, maxVal);
            val2 = random.nextInt(minVal, maxVal);
            System.out.println(val1 + "x" + val2 + "=");
            res = 0;
            try {
                // convert it to int
                res = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                // Silently ignore it
            }
            // check it against multiplied values of stored numbers
            if (val1 * val2 == res) {
                // advance the "right" or "wrong" counters
                right += 1;
            } else {
                wrong += 1;
            }
            // calculate the percentage
            // check iteration
            if ((!(i+1 < minRep)) && (percent <= (100 * (double) right / (double) (right + wrong)))) {
                break;
            }
            // if both are within values, end and display results
            // if not, continue
        }
        sc.close();
        System.out.println("Poprawnych: " + right);
        System.out.println("Procent: " + 100 * (double) right / (double) (right + wrong));
        System.out.println("Łącznie: " + (right + wrong));
    }
}
