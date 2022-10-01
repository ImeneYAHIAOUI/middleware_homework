package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IVODService  extends Remote {
    public List<MovieDesc> viewCatalog() throws RemoteException ;
    public Bill playmovie(String isbn, IClientBox box) throws RemoteException;
}
