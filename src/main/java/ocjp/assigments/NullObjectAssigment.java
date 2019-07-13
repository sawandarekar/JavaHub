package ocjp.assigments;

import javatest.testBeans.Person;

public class NullObjectAssigment {
    Person nullPerson = null;

    public static void main(String[] args) {
        NullObjectAssigment assigment = new NullObjectAssigment();
	System.out.println("nullString before assignment:" + assigment.nullPerson);
	assigment.assignObject(assigment.nullPerson);
	System.out.println("nullString after assignment:" + assigment.nullPerson);

    }

    private void assignObject(Person nullPerson) {
        nullPerson = new Person("name", "city", 20);
    }

    private Person assignAndReturnObject(Person nullPerson) {
        nullPerson = new Person("name", "city", 20);
        return nullPerson;
    }
}
