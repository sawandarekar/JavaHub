package ocjp.declationAndAccessControl;

enum EnumTest {

    ONE("one"), TWO("two");

    private String test = "";

    EnumTest(String s) {
        test = s;
    }

    String getSting() {
        return this.test;
    }

    public static void main(String[] args) {
        System.out.println(EnumTest.ONE.getSting());
    }

}
