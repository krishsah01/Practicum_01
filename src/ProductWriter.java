import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;

public class ProductWriter {
    public static void main(String[] args) {
        boolean doneInput = false;
        String ID = "";
        String Name = "";
        String Description = "";
        String rec = "";
        Double Cost = 0.0;

        ArrayList<String> goods = new ArrayList<String>();
        Scanner in = new Scanner(System.in);

        // create a loop to enter products data
        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter ID: ");
            Name = SafeInput.getNonZeroLenString(in, "Enter Name: ");
            Description = SafeInput.getNonZeroLenString(in, "Enter Description: ");
            Cost = SafeInput.getRangedDouble(in, "Enter Cost: ", 0, 9999999);
            rec = ID + ", " + Name + ", " + Description + ", " + Cost;

            System.out.println(rec);

            goods.add(rec);

            doneInput = SafeInput.getYNConfirm(in, "Are you done entering goods?");

        } while (!doneInput);

        File workingDirectory = new File(System.getProperty("user.dir"));
        String fileName = "ProductTestData" + ".txt";
        Path file = Paths.get(workingDirectory.getPath(), "src", fileName);

        try {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            // Write all records to the file
            for (String product : goods) {
                writer.write(product, 0, product.length());
                writer.newLine();  // adds the new line
            }

            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file " + fileName + " written!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}