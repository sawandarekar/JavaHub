package ocjp.stringsIOFormattingParsing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileExample {

    public static void main(String[] args) {
        try {

            final String content1 = "guid,status\n";
            final String content2 = "705cd7f3-87a9-4f99-a69b-b6020295c592,Closed";

            final File file = new File("filename.csv");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            final FileWriter fw = new FileWriter(file.getAbsoluteFile());
            final BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content1);
            bw.write(content2);
            bw.close();

            System.out.println("Done");

        } catch (final IOException e) {
            e.printStackTrace();
        }

    }

}
