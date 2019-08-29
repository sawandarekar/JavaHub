package ocjp.assigments;

import javatest.testBeans.Person;

public class NullObjectAssignment {

    Person nullPerson = null;

    public static void main(String[] args) {
        NullObjectAssignment assignment = new NullObjectAssignment();
        System.out.println("nullString before assignment:" + assignment.nullPerson);
        assignment.assignObject(assignment.nullPerson);
        System.out.println("nullString after assignment:" + assignment.nullPerson);
        assignment.nullPerson = assignment.assignAndReturnObject(assignment.nullPerson);
        System.out.println("nullString after assignment and return:" + assignment.nullPerson);
    }

    private void assignObject(Person nullPerson) {
        nullPerson = new Person("name", "city", 20);
    }

    private Person assignAndReturnObject(Person nullPerson) {
        nullPerson = new Person("name", "city", 20);
        return nullPerson;
    }
}
