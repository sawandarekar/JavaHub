package ocjp.objectOrientation;

public class DefaultValuesTest {
    boolean bln;
    byte b; // The byte data type is an 8-bit signed two's complement integer; minimum: -128 and maximum: 127 (inclusive)
    short s; //The short data type is a 16-bit signed two's complement integer; minimum: -32,768 and maximum: 32,767 (inclusive)
    int i; //the int data type is a 32-bit signed two's complement integer; minimum value of -231 and maximum value of 231-1
    long l; // type is a 64-bit two's complement integer; minimum: -263 and maximum: 263-1
    float f; // data type is a single-precision 32-bit IEEE 754 floating point; Its range of values is beyond the scope of this discussion
    double d;//Its range of values is beyond the scope of this discussion
    char c;//The char data type is a single 16-bit Unicode character; minimum: '\u0000' (or 0) and maximum: '\uffff' (or 65,535 inclusive).
    String[] arr;

    public static void main(String[] args) {
        DefaultValuesTest dVT = new DefaultValuesTest();
        System.out.println("boolean:"+dVT.bln);
        System.out.println("byte:"+dVT.b);
        System.out.println("short:"+dVT.s);
        System.out.println("int:"+dVT.i);
        System.out.println("long:"+dVT.l);
        System.out.println("float:"+dVT.f);
        System.out.println("double:"+dVT.d);
        System.out.println("char:"+dVT.c);
        System.out.println("string array:"+dVT.arr);
    }
}
