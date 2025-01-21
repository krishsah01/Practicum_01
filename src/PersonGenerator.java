import java.util.ArrayList;
import java.util.Scanner;import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;

public class PersonGenerator {
    public static void main(String[] args)
    {
        boolean doneInput = false;
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        String rec = "";
        int YOB = 0;

        ArrayList<String> people = new ArrayList<String>();
        Scanner in = new Scanner(System.in);

       // create a loop to enter persons data
        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter ID: ");
            firstName = SafeInput.getNonZeroLenString(in, "Enter First Name: ");
            lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name: ");
            title = SafeInput.getNonZeroLenString(in, "Enter Title: ");
            YOB = SafeInput.getRangedInt(in, "Enter Year of Birth: ", 1900, 2025);
            rec = ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;

            System.out.println(rec);

            people.add(rec);

            doneInput = SafeInput.getYNConfirm(in, "Are you done entering people ");

        }while(!doneInput);
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath(), "src", "data.txt");

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(String person : people)
            {
                writer.write(person, 0, person.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}