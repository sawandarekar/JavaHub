package javatest.others;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertyReadWrite {

    public static void main(final String[] args) {
        final String string = "sawan";
        final String resourcesPath = PropertyReadWrite.class.getResource("/").getPath();
        try {
            final Properties writeProperties = new Properties();
            final OutputStream os = new FileOutputStream(resourcesPath + "myproperty.properties");
            writeProperties.put(string, "darekar");
            writeProperties.setProperty("data", "property");

            writeProperties.store(os, null);
        } catch (final Exception e) {
            System.out.println("Exception in writing property: " + e);
        }

        try {
            final Properties readProperties = new Properties();
            final InputStream is = new FileInputStream(resourcesPath + "myproperty.properties");
            readProperties.load(is);
            System.out.println("data : " + readProperties.getProperty("data"));
            System.out.println(string + " : " + readProperties.get(string));

        } catch (final Exception e) {
            System.out.println("Exception in readin property: " + e);
        }
    }

}
