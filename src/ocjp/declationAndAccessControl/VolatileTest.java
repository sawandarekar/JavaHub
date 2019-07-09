package ocjp.declationAndAccessControl;

public class VolatileTest {

    public static void main(String[] args) {

        final VolatileObject volatileObject = new VolatileObject();
        new VolatileAccessThread("T1", volatileObject).start();
        new VolatileAccessThread("T2", volatileObject).start();
    }

}

class VolatileAccessThread extends Thread {

    VolatileObject volatileObject;
    private volatile int testValue;
    private volatile boolean ready;

    public VolatileAccessThread(String str, VolatileObject volatileObject) {
        super(str);
        this.volatileObject = volatileObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                if (getName().equals("T1")) {
                    ready = true;
                    testValue = i;
                    volatileObject.volatileInstaceVariable++;
                    volatileObject.nonVolatileInstaceVariable++;
                    System.out.println(i + "-" + getName() + " :: " + ready + " :: " + testValue + " :: volatile instance : "
                        + volatileObject.volatileInstaceVariable + " :: non volatile instance : "
                        + volatileObject.nonVolatileInstaceVariable);
                }
                if (getName().equals("T2")) {
                    System.out.println(i + "-" + getName() + " :: " + ready + " :: " + testValue
                        + " :: volatile from diff obj : " + volatileObject.volatileInstaceVariable
                        + " :: non volatile instance : " + volatileObject.nonVolatileInstaceVariable);
                }
                Thread.sleep(1000);
            } catch (final InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}

class VolatileObject {

    public int nonVolatileInstaceVariable = 1;
    public volatile int volatileInstaceVariable = 1;
}
