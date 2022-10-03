package contrats;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IVODService extends Remote {
    public Bill playmovie(String isbn, IClientBox box) throws RemoteException;
    public List<MovieDesc> viewCatalog() throws RemoteException;
}
