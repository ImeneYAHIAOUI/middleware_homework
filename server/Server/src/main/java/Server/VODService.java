package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class VODService extends UnicastRemoteObject implements   IVODService{

    protected VODService() throws RemoteException {
        super();
    }
    @Override
    public List<MovieDesc> viewCatalog() throws RemoteException{
        return null;
    }
    @Override
    public Bill playmovie(String isbn, IClientBox box) throws RemoteException{
        return new Bill();
    }

}
