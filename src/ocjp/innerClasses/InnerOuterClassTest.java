package ocjp.innerClasses;

public class InnerOuterClassTest {

    public static void main(final String[] args) {
        final OuterClass.StaticInnerClass staticInner = new OuterClass.StaticInnerClass();
        staticInner.whoAmI();

        final OuterClass outer = new OuterClass();
        outer.innerClassMethod();

        // final OuterClass.InnerClass inner = new InnerClass();
        // No enclosing instance of type OuterClass is accessible. Must qualify the allocation with an enclosing instance of
        // type OuterClass (e.g. x.new A() where x is an instance of OuterClass).
        final OuterClass.InnerClass inner = outer.new InnerClass();
        inner.whoAmI();

        final anonymousParentClass p = new anonymousParentClass() {
            // @Override
            // public void whoami() {
            // super.whoami();
            // System.out.println("Anonymous Child class");
            // }
        };
        p.whoami();
    }
}

class anonymousParentClass {

    public void whoami() {
        System.out.println("Anonymous Class Parent");
    }
}

class OuterClass {

    static int staticMember = 12;

    int defaultInstance = 20;
    public int publicInstance = 30;
    private final int privatetInstance = 40;

    public OuterClass() {
        System.out.println("I am Outer Class");
    }

    public void innerClassMethod() {

        class MethodInnerClass implements InnerInterface {

            @Override
            public void whoAmI() {
                System.out.println(
                    "Method Inner Class - all members of outer are accessible - method variables declared above class are accessible");
            }
        }
        final int innerMethodVariable = 10;
        final MethodInnerClass m = new MethodInnerClass();
        m.whoAmI();
    }

    class InnerClass implements InnerInterface {

        int classVariable = 50;

        @Override
        public void whoAmI() {
            System.out.println("Inner Class - All member of outer are accessible");
        }

        // Can define multiple inner classes
        class innerInnerClass {

            class inClass {

            }
        }
    }

    static {
        class StaticBlockInnerClass implements InnerInterface {

            @Override
            public void whoAmI() {
                System.out.println(
                    "static Block Inner Class : only static member accessible - can not be used outside this static block not even another static block");
            }
        }
        final StaticBlockInnerClass staticBlockInnerClass = new StaticBlockInnerClass();
        staticBlockInnerClass.whoAmI();
    }

    static class StaticInnerClass implements InnerInterface {

        @Override
        public void whoAmI() {
            System.out.println("Static Inner Class : only static member accessible");
        }
    }

    interface InnerInterface {

        public void whoAmI();
    }
}
