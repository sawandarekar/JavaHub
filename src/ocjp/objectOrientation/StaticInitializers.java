package ocjp.objectOrientation;

public class StaticInitializers {

    private static int a = 10;
    static {

        //System.out.println("a: " + a + " b: " + b); // Cannot reference a field before it is defined
        if (a == 10) {
            b = 30;
        }
    }
    private static int b = 20;

    public static void main(final String[] args) {
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

}
