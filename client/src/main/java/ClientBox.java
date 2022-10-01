import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import contrats.IClientBox;
public class ClientBox extends UnicastRemoteObject implements IClientBox {
    public ClientBox() throws RemoteException {
    }
    public void stream(byte[] chunck) throws RemoteException {

    }

}

