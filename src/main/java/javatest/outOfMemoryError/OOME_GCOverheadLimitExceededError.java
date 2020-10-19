package javatest.outOfMemoryError;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * -Xmx100m -XX:+UseParallelGC: OutOfMemoryError: GC overhead limit exceeded
 */
public class OOME_GCOverheadLimitExceededError {

    public static void main(String args[]) throws Exception {
        Map m = new HashMap();
        m = System.getProperties();
        m.forEach((k,v) -> System.out.println(k+":"+v));
        Random r = new Random();
        while (true) {
            m.put(r.nextInt(), "randomValue");
        }
    }
}
