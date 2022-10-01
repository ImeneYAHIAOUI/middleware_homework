
import contrats.IConnection;
import contrats.MovieDesc;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server
{
    public static void main( String[] args )
    {
        try{
            // crée l'objet distant
            Connection obj = new Connection();
            obj.VodService.AddMovie(new MovieDesc("EGO","100234745","sjhdjs"));
            obj.VodService.AddMovie(new MovieDesc("L'arnaqueur de tinder","123889245","Tinder"));

            // ici, nous exportons l'objet distant vers le stub
            IConnection stub = (IConnection) UnicastRemoteObject.exportObject(obj, 2001);
            Registry reg = LocateRegistry.getRegistry(1099);
            // Liaison de l'objet distant (stub) dans le Registre
            reg.rebind("Connection", stub);
            System.out.println("Le Serveur est prêt...");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
