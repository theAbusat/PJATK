public class TooManyThingsException extends Exception {
    public String message;

    public TooManyThingsException(String message){
        super(message);
    }
}
