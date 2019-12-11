package ocjp.declationAndAccessControl;

/**
 * https://blogs.oracle.com/javamagazine/quiz-yourself-identify-the-scope-of-variables-intermediate
 */
public class WeirdLoop {

    public static int i = 99;
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) { // line n1
            System.out.print(i);
            i++; // line n2
            break;
        }
        System.out.println("i:"+i);
    }
}
