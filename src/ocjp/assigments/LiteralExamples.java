package ocjp.assigments;

public class LiteralExamples {

    public static void main(String[] args) {
        final int dec = 123;
        System.out.println("i : " + dec);
        final int octal = 010;
        System.out.println("octal : " + octal);
        final int hex1 = 0xdead;
        final int hex2 = 0XDEAD;
        System.out.println("Hex1 : " + hex1);
        System.out.println("values of hex are case insensitive so result is same");
        System.out.println("Hex2 : " + hex2);
    }

}
