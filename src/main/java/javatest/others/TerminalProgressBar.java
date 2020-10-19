package javatest.others;

import java.io.IOException;

public class TerminalProgressBar {

    public static void main(String[] args) throws IOException, InterruptedException {
        String anim= "|/-\\";
        for (int x =0 ; x < 100 ; x++) {
            String data = "\r" + anim.charAt(x % anim.length()) + " " + x;
            System.out.write(data.getBytes());
            Thread.sleep(100);
        }
    }
}
