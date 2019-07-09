package ocjp.stringsIOFormattingParsing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class SerializableTest implements Serializable {

    String firstString = "first data";
    int firstInt = 10;
    static String resourcesPath = SerializableTest.class.getResource("/").getPath();
    static String fileName = resourcesPath + "serialize.txt";
    // instance object must have implement Serializable
    innerSerializableOne innerOne = new innerSerializableOne();

    // java.io.NotSerializableException : innerSerializableTwo class does not implement Serializable.
    // use transiant to write the object
    // transient innerSerializableTwo innerTwo = new innerSerializableTwo();

    public static void main(final String[] args) {
        final SerializableTest sTest = new SerializableTest();
        writeSerializableObject(sTest);
        readSerializableObject();

    }

    /**
     * Writing object
     *
     * @param sTest
     */
    private static void writeSerializableObject(final SerializableTest sTest) {
        FileOutputStream fout = null;
        ObjectOutputStream out = null;
        try {
            fout = new FileOutputStream(new File(fileName));
            out = new ObjectOutputStream(fout);

            out.writeObject(sTest);
            out.flush();
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("writing object success");
    }

    /**
     * read serializable object.
     *
     * @param sTest
     */
    private static void readSerializableObject() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        SerializableTest sTest = null;
        try {
            fis = new FileInputStream(new File(fileName));
            ois = new ObjectInputStream(fis);
            final Object object1 = ois.readObject();

            if (object1 instanceof SerializableTest) {
                sTest = (SerializableTest)object1;
                System.out.println(sTest);
            }

        } catch (final Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(firstString + " ");
        sb.append(firstInt + " ");
        sb.append(fileName + " ");
        sb.append(" innerOne :" + innerOne.a + " " + innerOne.test);
        // sb.append(" innerTwo :" + innerTwo.a + " " + innerTwo.test);

        return sb.toString();
    }
}

@SuppressWarnings("serial")
class innerSerializableOne implements Serializable {

    int a = 20;
    String test = "test";
}

class innerSerializableTwo {

    int a = 20;
    String test = "test";
}
