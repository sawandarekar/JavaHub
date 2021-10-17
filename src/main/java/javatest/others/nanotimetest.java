package javatest.others;

import java.util.stream.IntStream;

public class nanotimetest {
  public static void main(String[] args) {
    IntStream.range(0, 100).forEach(i->{
      System.out.println("nanotime:"+System.nanoTime());
    });
  }
}
