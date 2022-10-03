package contrats;

public class SignInFailedException extends Exception {
    public SignInFailedException(){
        super();
    }
    public SignInFailedException(String ErrorMessage){
        super(ErrorMessage);
    }
}
