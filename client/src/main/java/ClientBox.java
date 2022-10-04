import contrats.IClientBox;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientBox extends UnicastRemoteObject implements IClientBox {
    public ClientBox() throws RemoteException {
    }
    public  synchronized void stream(byte[] chunck) throws RemoteException {
        System.out.println(chunck);



    }

}

