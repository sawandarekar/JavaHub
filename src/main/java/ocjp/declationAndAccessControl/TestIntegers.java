package ocjp.declationAndAccessControl;

public class TestIntegers {

    public static void main(final String[] args) {
        calculateValue();
        checkParseInt();
    }

    private static void checkParseInt() {
        final String string = "000345";
        System.out.println(string + ": Parse Int value =" + Integer.parseInt(string));
    }

    private static void calculateValue() {
        final Integer a = 127;
        final Integer b = 127;
        final Integer c = 128;
        final Integer d = 128;
        System.out.println("Integer");
        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println("Integer equals");
        System.out.println(a.equals(b));
        System.out.println(c.equals(d));

        final Double a1 = 127.1;
        final Double b1 = 127.1;
        final Double c1 = 128.1;
        final Double d1 = 128.1;
        System.out.println("\nDouble");
        System.out.println(a1 == b1);
        System.out.println(c1 == d1);

        final Long a2 = 127L;
        final Long b2 = 127L;
        final Long c2 = 128L;
        final Long d2 = 128L;
        System.out.println("\nLong");
        System.out.println(a2 == b2);
        System.out.println(c2 == d2);
    }

}
