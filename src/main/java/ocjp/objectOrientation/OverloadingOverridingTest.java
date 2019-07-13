package ocjp.objectOrientation;

import java.util.ArrayList;
import java.util.Collection;

public class OverloadingOverridingTest {

    public static void main(final String[] args) {
        final Animal a = new Animal();
        a.eat();
        final Horse h = new Horse();
        h.eat();
        final Animal a1 = new Horse();
        a1.eat();
        final Animal a2 = new Horse();
        ((Horse)a2).eat("Apple");
        final Animal[] array = {new Animal(), new Horse()};
        for (final Animal an : array) {
            an.eat();
        }

        // the relationship between remove(int) and remove(Object) is one of method overloading, not method overriding, which
        // means that the compiler decides which method to invoke
        final Collection<String> coll = new ArrayList<>();
        coll.add("asd");
        coll.add("sdf");
        coll.add("gfd");
        System.out.println("Coll is: " + coll);
        coll.remove(0);
        System.out.println("Coll is: " + coll);

        final Animal a3 = new Animal();
        ((Horse)a3).eat("Apple");
        // Downcasting thows Class Cast Exception
    }

}

class Animal {

    void eat() {
        System.out.println("Animal Eating");
    }
}

class Horse extends Animal {

    @Override
    void eat() {
        System.out.println("Horse Eating");
    }

    public void eat(final String what) {
        System.out.println("Horse Eating : " + what);
    }
}
