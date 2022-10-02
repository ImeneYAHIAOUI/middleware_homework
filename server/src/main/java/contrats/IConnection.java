package contrats;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IConnection extends Remote {
    public boolean signIn(String mail, String pwd) throws SignInFailedException, RemoteException;
    public IVODService login(String mail, String pwd) throws InvalidCredentialsException, RemoteException;
}
