package javatest.others;

public class StaticClassTest {

    {
	System.out.println("just block");
    }
    static {
	StaticClassTest classTest1 = new StaticClassTest();
	classTest1.display();
    }

    // public static void main(String[] args) {
    // StaticClassTest classTest = new StaticClassTest();
    // classTest.display();
    // }

    public void display() {
	System.out.println("Display print");
    }

}
