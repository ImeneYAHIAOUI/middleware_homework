package Server;

public class SignInFailed  extends Exception {
    public SignInFailed(){
        super();
    }
    public SignInFailed(String ErrorMessage){
        super(ErrorMessage);
    }
}
