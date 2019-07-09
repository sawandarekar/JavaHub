package ocjp.flowControlAndExceptions;

public class ReturnInTry {

    public static void main(String[] args) {
	ReturnInTry inTry = new ReturnInTry();
	String rs = inTry.returnInTry();
	System.out.println("From try block function:" + rs);
    }

    private String returnInTry() {
	String rs = "from function";
	try {
	    rs = "from try";
	    return rs;
	} catch (Exception e) {
	    rs = "from Finally";
	}
	return rs;
    }
}
