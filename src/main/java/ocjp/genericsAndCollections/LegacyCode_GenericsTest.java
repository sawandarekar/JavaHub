package ocjp.genericsAndCollections;

import java.util.ArrayList;
import java.util.List;

/*
 * A non-generic collection can hold any kind of object. non-generic collection is quite happy to hold anything that is NOT primitive.
 */
public class LegacyCode_GenericsTest {

    public static void main(String[] args) {
        final List l = new ArrayList();
        final LegacyCode_GenericsTest leTest = new LegacyCode_GenericsTest();
        l.add(new String("sawan"));
        leTest.add(l);
        leTest.printList(l);

        final Animal[] animalArray = new Animal[5];// OK
        final Animal[] dogArray = new Dog[5];// OK
        final Animal[] catArray = new Cat[5];// OK
        // final List<Animal> ls = new ArrayList<Dog>();
        // final List<Dog> lsD = new ArrayList<Animal>();
        // Type mismatch: cannot convert from ArrayList<Dog> to List<Animal>

        final List<Animal> lss = new ArrayList<>();
        // Right and left hand should be same while generics
    }

    public void add(List ls) {
        ls.add(new Integer(12));
    }

    public void printList(List l) {
        for (final Object o : l) {
            System.out.println(o);
        }
    }

}

class Animal {

    int name;

}

class Dog extends Animal {

}

class Cat extends Animal {

}
