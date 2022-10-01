package contrats;


import java.rmi.Remote;

public interface IConnection extends Remote {
    public boolean signIn(String mail, String pwd) throws SignInFailedException;
    public IVODService login(String mail, String pwd) throws InvalidCredentialsException;
}
