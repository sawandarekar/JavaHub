package ocjp.stringsIOFormattingParsing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;

import javatest.others.Test;

public class FileEncodingCheck {

    public void availableCharsets() {
        final SortedMap<String, Charset> charsetMap = Charset.availableCharsets();
        final Iterator<Map.Entry<String, Charset>> entries = charsetMap.entrySet().iterator();
        System.out.println("Toatal Charset: " + charsetMap.size());
        while (entries.hasNext()) {
            final Entry<String, Charset> entry = entries.next();
            final Charset set = entry.getValue();

            System.out.println(entry.getKey() + " : " + entry.getValue() + " : " + set.displayName() + " aliases:"
                + set.aliases().toString());
        }
    }

    public void printFileEncoding(final String fileName) {

    }

    public void readWriteFile(final String fileName) {

        final String resourcesPath = Test.class.getResource("/").getPath();
        try {
            final File fileDir = new File(fileName);
            final InputStreamReader reader = new InputStreamReader(new FileInputStream(fileDir), "US-ASCII");
            final File outFile = new File(resourcesPath + "stable_check.txt");
            System.out.println("writing path : " + outFile.getAbsolutePath());
            final Writer writer = new OutputStreamWriter(new FileOutputStream(outFile), "US-ASCII");
            System.out.println("File name:" + fileName + " Encoding:" + reader.getEncoding());
            final BufferedReader in = new BufferedReader(reader);
            String str;
            System.out.println("writing file");
            while ((str = in.readLine()) != null) {
                writer.write(str);
            }
            System.out.println("writing file completed");
            in.close();
            reader.close();
            writer.close();
        } catch (final UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (final IOException e) {
            System.out.println(e.getMessage());
        } catch (final Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(final String[] args) {
        final FileEncodingCheck fileEncodingCheck = new FileEncodingCheck();

        // fileEncodingCheck.readWriteFile("E:\\FCOTest\\source_files\\MECandidateUploader_amman_24_stablecheck.csv");
        fileEncodingCheck.readWriteFile("E:\\GIT_workspace\\JavaHub\\target\\classes\\MyFile.txt");

        fileEncodingCheck.availableCharsets();
    }
}
