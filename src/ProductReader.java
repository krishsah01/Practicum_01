import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;
import javax.swing.JFileChooser;

public class ProductReader {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";

        try {
            // use the toolkit to get the current working directory of the IDE
            File workingDirectory = new File(System.getProperty("user.dir"));

            // set the current directory of the chooser to the working directory
            chooser.setCurrentDirectory(workingDirectory);

            // Using the chooser adds some complexity to the code.
            // we have to code the complete program within the conditional return of
            // the filechooser because the user can close it without picking a file
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                // Typical java pattern of inherited classes
                // we wrap a BufferedReader around a lower level BufferedInputStream
                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                // Print column headers
                printColumnHeaders();

                // Finally we can read the file LOL!
                int line = 0;
                while (reader.ready()) {
                    rec = reader.readLine();
                    line++;
                    // Print the data in a columnar format
                    printDataRecord(rec);
                }
                reader.close(); // must close the file to seal it and flush buffer
                System.out.println("\n\nData file read!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printColumnHeaders() {
        System.out.printf("%-10s %-15s %-15s %-10s %-5s\n", "ID", "First Name", "Last Name", "Title", "YOB");
        System.out.println("-------------------------------------------------------------");
    }

    private static void printDataRecord(String rec) {
        String[] fields = rec.split(", ");
        System.out.printf("%-10s %-15s %-15s %-10s %-5s\n", fields[0], fields[1], fields[2], fields[3], fields[4]);
    }
}