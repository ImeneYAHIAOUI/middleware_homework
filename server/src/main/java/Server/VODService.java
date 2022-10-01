package Server;

import Server.contrats.IVODService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class VODService  extends UnicastRemoteObject implements IVODService {
    protected VODService() throws RemoteException {

    }
}
