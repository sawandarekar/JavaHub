package javatest.others;

public class Test_Exponential {

    public static void main(String[] args) {
        final Test_Exponential t = new Test_Exponential();
        int ik = 0;
        System.out.println("1e-2f : " + 1e-2f);
        System.out.println("1e-3f : " + 1e-3f);
        System.out.println("1e-4f : " + 1e-4f);
        System.out.println("1e-5f : " + 1e-5f);
        for (float f = 16384; f < 16384 + 1; f += 1e-3f) {
            ik++;
            System.out.println("f:" + f + " ik:" + ik);
        }
    }

}
