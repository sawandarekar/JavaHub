package javatest.outOfMemoryError;


import javassist.ClassPool;

/**
 * -XX:MaxPermSize=256m
 */
public class OOME_PermGenSpaceError {
    static ClassPool classPool = ClassPool.getDefault();

    public static void main(String args[]) throws Exception
    {
        for (int i = 0; i < 1000000000; i++) {
            Class c = classPool.makeClass("javatest.outOfMemoryError" + i).toClass();
                System.out.println(c.getName());
        }
    }
}
