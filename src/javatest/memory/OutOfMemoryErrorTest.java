package javatest.memory;

import java.util.HashMap;
import java.util.Map;

public class OutOfMemoryErrorTest {

    public static Map<String, OutOfMemoryErrorTest> oomeMap = new HashMap<>();
    public String stringInstance =
        "My Data, My Data, My Data, My Data, My Data, My Data, My Data, My Data, My Data, My Data, My Data, My Data";

    public static void main(final String[] args) {
        for (int i = 0; i < 100000000; i++) {
            final OutOfMemoryErrorTest outOfMemoryError = new OutOfMemoryErrorTest();
            oomeMap.put(i + "", outOfMemoryError);
            Runtime rt = Runtime.getRuntime();
            System.out.println(i + "free memory: " + rt.freeMemory() + ":" + outOfMemoryError.stringInstance);
        }
    }
}
