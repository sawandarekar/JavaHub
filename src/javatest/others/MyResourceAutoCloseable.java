package javatest.others;

class MyResource implements AutoCloseable {

    private final String name;

    public MyResource(final String name) {
        this.name = name;
    }

    @Override
    public void close() {
        System.out.println("Close:" + name);
    }
}

public class MyResourceAutoCloseable {

    public static void main(final String[] args) {
        try (MyResource one = new MyResource("one"); MyResource two = new MyResource("two")) {
        } finally {
            System.out.println("three");
        }
    }
}