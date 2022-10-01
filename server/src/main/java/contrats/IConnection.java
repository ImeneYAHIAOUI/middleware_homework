package contrats;
import java.rmi.Remote;

public interface IConnection extends Remote {
    public boolean signIn(String mail, String pwd) throws SignInFailed;
    public IVODService login(String mail, String pwd) throws InvalidCredentialsException;
}
