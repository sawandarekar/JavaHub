package ocjp.stringsIOFormattingParsing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * this file saved in UTF-8 Encoding
 * 
 * @author darekar
 */
public class ReadUTF8EncodedFile {

    static String FileName = "MyFile.txt";
    static String FilePath = ReadUTF8EncodedFile.class.getResource("/").getPath();

    public static void main(final String[] args) {
        String line;
        try {
            System.out.println("File : " + FilePath + FileName);
            final File f = new File(FilePath + FileName);
            final InputStreamReader ir = new InputStreamReader(new FileInputStream(f), Charset.forName("UTF8"));
            final BufferedReader br = new BufferedReader(ir);// Files.newBufferedReader(Paths.get(FilePath + FileName),
                                                             // Charset.forName("UTF-8"));
            while ((line = br.readLine()) != null) {
                final String s0 = new String(line.getBytes("UTF-8"), Charset.forName("UTF8"));
                final String s1 = new String(line.getBytes("UTF-8"), Charset.forName("UTF8"));
                System.out.println(s0 + " equals " + s1 + " = " + s0.equals(s1));
                // System.out.println(line);
            }
            br.close();
        } catch (final IOException ex) {
            ex.printStackTrace();
        }
    }

}
