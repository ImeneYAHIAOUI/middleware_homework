import contrats.IClientBox;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import static java.lang.System.out;

public class ClientBox extends UnicastRemoteObject implements IClientBox {
    public ClientBox() throws RemoteException {
    }
    public  synchronized void stream(byte[] chunck) throws RemoteException {
        try {
            FileOutputStream out = new FileOutputStream("video.mp4");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            out.write(chunck);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

