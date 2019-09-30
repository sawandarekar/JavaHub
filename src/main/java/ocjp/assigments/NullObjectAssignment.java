package ocjp.assigments;

import javatest.testBeans.Person;

public class NullObjectAssignment {

    Person nullPerson = null;
    Person person = new Person("test","city", 23);

    public static void main(String[] args) {
        NullObjectAssignment assignment = new NullObjectAssignment();
        System.out.println("nullPerson before assignment:" + assignment.nullPerson);
        assignment.assignObject(assignment.nullPerson);
        System.out.println("nullPerson after assignment:" + assignment.nullPerson);
        assignment.nullPerson = assignment.assignAndReturnObject(assignment.nullPerson);
        System.out.println("nullPerson after assignment and return:" + assignment.nullPerson);
        System.out.println("-----------------------------");
        System.out.println("person before assignment:" + assignment.person);
        assignment.assignObject(assignment.person);
        System.out.println("person after assignment:" + assignment.person);
        assignment.person = assignment.assignAndReturnObject(assignment.person);
        System.out.println("person after assignment and return:" + assignment.person);
    }

    private void assignObject(Person nullPerson) {
        nullPerson = new Person("ass_name", "ass_city", 20);
    }

    private Person assignAndReturnObject(Person nullPerson) {
        nullPerson = new Person("ass_ret_name", "ass_ret_city", 20);
        return nullPerson;
    }
}
