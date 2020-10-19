package javatest.outOfMemoryError;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms156M -Xmx256M  : java.lang.OutOfMemoryError: Java heap space
 */
public class OOME_JavaHeapSpaceError {

    static List<String> list = new ArrayList<String>();

    public static void main(String args[]) throws Exception {
        Integer[] array = new Integer[10000 * 10000];
    }
}
