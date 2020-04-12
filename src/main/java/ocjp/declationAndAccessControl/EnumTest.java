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
        EnumTest test = EnumTest.ONE;
        System.out.println(test.getSting());
        test = EnumTest.TWO;
        System.out.println(test.getSting());
    }

}
