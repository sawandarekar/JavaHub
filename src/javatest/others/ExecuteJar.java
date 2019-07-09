package javatest.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExecuteJar {

    public static void main(String[] args) {
        try {
            List<String> command = new ArrayList<>();
            command.add("java");
            command.add("-jar");
            // command.add("C:\\DDrive\\Test_Workspace\\my projects\\my github\\InJdk8\\target\\InJdk8-0.0.1-SNAPSHOT.jar");
            command.add("C:\\MCD\\jenkins-cli.jar");
            command.add("-s");
            command.add("http://jenkins.tomtomgroup.com/");
            command.add("get-job");
            command.add("Anomaly-Common Release");
            // command.add(">");
            command.add("Anomaly-Common Release.xml");
            command.add("--username");
            command.add("moream");
            command.add("--password");
            command.add("Incredible@17a");

            ProcessBuilder pb = new ProcessBuilder(command);
            Process process = pb.start();

            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s = "";
            while ((s = in.readLine()) != null) {
                System.out.println(s);
            }
            in.close();
            System.out.println("Error Stream");
            BufferedReader es = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String s1 = "";
            while ((s1 = es.readLine()) != null) {
                System.out.println(s1);
            }
            es.close();

            process.waitFor();
            int status = process.exitValue();
            System.out.println("Process Execution completed exitValue:" + status);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
