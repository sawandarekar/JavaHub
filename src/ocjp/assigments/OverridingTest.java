package ocjp.assigments;

public class OverridingTest extends ParentOverriding {

    @Override
    // void dummy() {Cannot reduce the visibility of the inherited method from ParentOverriding
    public void dummy() {
    }
}

class ParentOverriding {

    protected void dummy() {

    }
}
