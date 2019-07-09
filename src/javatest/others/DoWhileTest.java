package javatest.others;


public class DoWhileTest {

    public static void main(String[] args) {
        int retry = 0;
        do {
            try {
                System.out.println("Retry : "+retry);
                //                if(retry == 0) {
                throw new Exception();
                //                }
                //break;
            }catch (Exception e) {
                retry++;
                System.out.println("Exeption occured - Retry");
            }
        }while(retry < 3);

        System.out.println("completed: "+retry);
    }

}
