/*this java code will help allow us provide a
message inside the special type Exception*/

public class JobNotFoundException extends Exception {

    public JobNotFoundException(String message) {
        super(message);// any message passed here will be used in java Exception class
    }
}

