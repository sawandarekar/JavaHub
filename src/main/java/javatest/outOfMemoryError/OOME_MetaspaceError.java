package javatest.outOfMemoryError;

/**
 * -XX:MaxMetaspaceSize=64m : OutOfMemoryError: Metaspace
 */
public class OOME_MetaspaceError {

    static javassist.ClassPool cp = javassist.ClassPool.getDefault();

    public static void main(String args[]) throws Exception {
        for (int i = 0; i < 100000; i++) {
            Class c = cp.makeClass("javatest.outOfMemoryError.Metaspace" + i).toClass();
        }
    }
}
