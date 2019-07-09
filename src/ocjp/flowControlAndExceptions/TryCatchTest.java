package ocjp.flowControlAndExceptions;

public class TryCatchTest {

    public static void main(String[] args) {
        try {
            System.out.println("try");
        } // Syntax error, insert "Finally" to complete TryStatement
        // catch (Exception e) {
        // System.out.println("catch");
        // e.printStackTrace();
        // }
	finally {
	    System.out.println("finally");
	}
    }
}
