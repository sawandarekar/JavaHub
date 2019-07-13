package ocjp.assigments;

public class StaticBlockInitialization {

    public static void main(String[] args) {
        new Init(2);
        new Init(4);
    }

}

class Init {

    int i = 4;
    static int j = 13;
    {
        System.out.println("executed at each object creation : First block : " + j);
    }
    static {
        System.out.println("Executed only once and at early and before constructor : First static block : " + j);
    }
    {
        System.out.println("Second Block - Executed at object creation i:" + i);
    }
    static {
        System.out.println("Executed only once and at early : Second Static Block");
    }

    Init(int s) {
        System.out.println("Executed after static and empty block : Contructor Initialization");
    }
}