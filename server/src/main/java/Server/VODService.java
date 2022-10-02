package Server;

import contrats.*;
import contrats.IVODService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class VODService  extends UnicastRemoteObject implements IVODService {
    protected VODService() throws RemoteException {

    }

    @Override
    public Bill playmovie(String isbn, IClientBox box) {
        return null;
    }

    @Override
    public List<MovieDesc> viewCatalog() {
        return null;
    }
}
