package javatest.others;

import java.net.InetAddress;

public class ReadMachineDetails {

    public static void main(String[] args) {
        try {
            final InetAddress localMachine = InetAddress.getLocalHost();
            System.out.println("Host Address : " + localMachine.getHostAddress());
            System.out.println("Host Name : " + localMachine.getHostName());
            System.out.println("Canonical Host Name : " + localMachine.getCanonicalHostName());
            System.out.println("Address : " + new String(localMachine.getAddress()));
        } catch (final Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
