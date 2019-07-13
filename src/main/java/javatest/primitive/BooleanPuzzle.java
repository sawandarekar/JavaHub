package javatest.primitive;

public class BooleanPuzzle {
    public static void main(String[] args) {
	boolean b1 = true, b2 = true;
	if ((b1 = false) | b1 ^ b2) {
	    System.out.println("Eclipse");
	}
	System.out.println("Bye");
    }
}
