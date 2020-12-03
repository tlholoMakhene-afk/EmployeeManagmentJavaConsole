package RMIServer;

public class MyServerExceptions {
	public class CustomException extends Exception{

	    public CustomException() {
	    }

	    public CustomException(String string) {
	        super(string);
	    }

	    public CustomException(String string, Throwable thrwbl) {
	        super(string, thrwbl);
	    }

	    public CustomException(Throwable thrwbl) {
	        super(thrwbl);
	    }
	    
	    
	}
	
}
