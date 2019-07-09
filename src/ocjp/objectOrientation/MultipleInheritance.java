package ocjp.objectOrientation;

public class MultipleInheritance extends protectedMemberClass implements First, Second {

    String main;

    MultipleInheritance(String a) {
        this.main = a;
    }

    public static void main(String[] args) {
        final First f = new MultipleInheritance("first");
        f.data();
        final Second s = (Second)f;
        s.data();

        final MultipleInheritance ml = new MultipleInheritance("protected");
        ml.protectedMethod();
    }

    @Override
    public void data() {
        System.out.println(this.main);
    }

    @Override
    protected void protectedMethod() {
        // super.protectedMethod();
        System.out.println("child protected method");
    }

}

interface First {

    public void data();
}

interface Second {

    public void data();
}

class protectedMemberClass {

    protected void protectedMethod() {
        System.out.println("protected function data method");
    }
}