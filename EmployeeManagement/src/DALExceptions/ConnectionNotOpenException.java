package DALExceptions;

	public class ConnectionNotOpenException extends Exception{

	    public ConnectionNotOpenException() {
	    }

	    public ConnectionNotOpenException(String string) {
	        super(string);
	    }

	    public ConnectionNotOpenException(String string, Throwable thrwbl) {
	        super(string, thrwbl);
	    }

	    public ConnectionNotOpenException(Throwable thrwbl) {
	        super(thrwbl);
	    }
}
	
    
    
