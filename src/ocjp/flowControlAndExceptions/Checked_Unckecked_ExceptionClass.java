package ocjp.flowControlAndExceptions;

public class Checked_Unckecked_ExceptionClass {

    public static void main(String[] args) {
        final Checked_Unckecked_ExceptionClass ex = new Checked_Unckecked_ExceptionClass();

        try {
            ex.checkedExceptionThrower();
        } catch (final CheckedException e) {
            System.out.println("checked exception handled in catch");
            e.printStackTrace();
	} finally {
	    System.out.println("checked exception finally");
        }

	try {
	    ex.uncheckedExceptionThrower();
	} finally {
	    System.out.println("unchecked exception finally");
	}

    }

    public void uncheckedExceptionThrower() {
	int i = 12 / 0;
    }

    public void checkedExceptionThrower() throws CheckedException {
        throw new CheckedException("checked exception");
    }
}

class UncheckedException extends RuntimeException {

    String message;

    UncheckedException(String m) {
        message = m;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

class CheckedException extends Exception {

    String message;

    CheckedException(String m) {
        message = m;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
