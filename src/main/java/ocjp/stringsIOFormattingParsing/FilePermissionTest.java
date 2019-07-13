package ocjp.stringsIOFormattingParsing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilePermission;
import java.security.AccessControlException;
import java.security.AccessController;

public class FilePermissionTest {

    public static void main(final String[] args) {
        final String path = "C:\\DDrive\\PlacesTestData\\innovation_test";
        System.out.println("path: " + path);

        securityManagerPermissionCheck(path);

        accessControllerPermissionChcek(path);

        filePermissionCheck(path);

    }

    private static void filePermissionCheck(final String path) {
        System.out.println("------------------------------");
        System.out.println("File f.canWrite()");
        System.out.println("Path:" + path);
        final File f = new File(path);
        if (f.canRead()) {
            System.out.println("read possible");
        } else {
            System.out.println("read not possible");
        }
        if (f.canWrite()) {
            System.out.println("write possible");
        } else {
            System.out.println("write not possible");
        }
        if (f.canExecute()) {
            System.out.println("Execute possible");
        } else {
            System.out.println("Execute not possible");
        }
    }

    private static void accessControllerPermissionChcek(final String path) {
        System.out.println("------------------------------");
        System.out.println("AccessController.checkPermission");
        try {
            AccessController.checkPermission(new FilePermission(path, "read"));
            System.out.println("read success");
            AccessController.checkPermission(new FilePermission(path, "write"));
            System.out.println("write success");
            AccessController.checkPermission(new FilePermission(path, "execute"));
            System.out.println("write success");
            AccessController.checkPermission(new FilePermission(path, "delete"));
            System.out.println("delete success");
        } catch (final AccessControlException e) {
            System.out.println("AccessControlException: " + e.getMessage());
        }
    }

    private static void securityManagerPermissionCheck(final String path) {
        FileOutputStream fileOutputStream = null;
        final SecurityManager securityManager = new SecurityManager();
        System.out.println("securityManager.checkWrite");
        try {
            securityManager.checkRead(path);
            System.out.println("Read possible");
            securityManager.checkWrite(path);
            System.out.println("write possible");
            securityManager.checkDelete(path);
            System.out.println("Delete possible");

            fileOutputStream = new FileOutputStream(path);

        } catch (final SecurityException se) {
            System.out.println("SecurityException : " + se.getMessage());
        } catch (final FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        }
    }
}
