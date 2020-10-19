package javatest.outOfMemoryError;

import java.util.Vector;

public class MemoryEater {

    public static void main(String[] args) {
        Vector v = new Vector();
        int j = 0;
        while (true) {
            byte b[] = new byte[1048576];
            v.add(b);
            Runtime rt = Runtime.getRuntime();
            System.out.println("Available processores:" + Runtime.getRuntime().availableProcessors() + " free memory: " + rt.freeMemory());
            j++;
            if (j == Integer.MIN_VALUE) { // true at Integer.MAX_VALUE +1
                break;
            }
        }
    }
}
