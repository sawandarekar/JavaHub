package javatest.outOfMemoryError;

/**
 *
 */
public class OOME_StackTraceWithNativeError {

    public static void main(String args[]) throws Exception {
        while (true) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1_00_00_00_000);
                    } catch (InterruptedException e) {
                    }
                }
            }).start();
        }
    }
}
