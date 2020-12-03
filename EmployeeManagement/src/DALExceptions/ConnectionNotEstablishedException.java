package DALExceptions;

public class ConnectionNotEstablishedException extends Exception{

    public ConnectionNotEstablishedException() {
    }

    public ConnectionNotEstablishedException(String string) {
        super(string);
    }

    public ConnectionNotEstablishedException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ConnectionNotEstablishedException(Throwable thrwbl) {
        super(thrwbl);
    }
}
