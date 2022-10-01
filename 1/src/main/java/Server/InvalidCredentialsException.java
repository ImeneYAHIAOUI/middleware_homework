package Server;

public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(){
        super();
    }
    public InvalidCredentialsException(String ErrorMessage){
        super(ErrorMessage);
    }
}