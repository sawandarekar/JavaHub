package javatest.others;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

public class ConvertImageToBase64 {

    public static void main(final String[] args) {
        try {
            // final String imageName = args[0];
            final String imageName = "E:\\Geotagged_Image_007.jpg";
            System.out.println("Image : " + imageName);
            if (!imageName.isEmpty()) {
                final byte[] imageBytes = new ConvertImageToBase64().getImageBytes(imageName);
                // final byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(new File(imageName)));
                final String base64 = Base64.getEncoder().encodeToString(imageBytes);

                final FileWriter fw = new FileWriter(new File(imageName + ".txt"));
                final BufferedWriter bw = new BufferedWriter(fw);
                bw.write(base64);
                bw.close();
                System.out.println("Converting Done at location:" + imageName);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    byte[] getImageBytes(final String fileName) throws IOException {
        final File file = new File(fileName);
        // init array with file length
        final byte[] bytesArray = new byte[(int)file.length()];

        final FileInputStream fis = new FileInputStream(file);
        fis.read(bytesArray); // read file into bytes[]
        fis.close();

        return bytesArray;
    }
}
