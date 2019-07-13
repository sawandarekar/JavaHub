package ocjp.objectOrientation;


public class StaticInitializersParents extends  StaticInitializersParentsB {
    static{
        System.out.println("c");
    }
    public static void main(String[] args) {
        StaticInitializersParents initializersParents = new StaticInitializersParents();
        StaticInitializersParents initializersParents1 = new StaticInitializersParents();
    }

}

class StaticInitializersParentsA {
    static{
        System.out.println("A");
    }
}
class StaticInitializersParentsB extends  StaticInitializersParentsA {
    static{
        System.out.println("B");
    }
}

