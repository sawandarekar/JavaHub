package javatest.eclipsePuzzle;

public class StaticMethodCalls {

    public static void main(String[] args) {
        m();
    }

    private static void m(short... b) {
        System.out.println("2");
    }

    private static void m(int... a) {
        System.out.println("1");
    }
}
