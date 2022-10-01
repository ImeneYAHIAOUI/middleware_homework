package Server;


import Server.contrats.IConnection;

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
            // ici, nous exportons l'objet distant vers le stub
            IConnection stub = (IConnection) UnicastRemoteObject.exportObject(obj, 2001);
            Registry reg = LocateRegistry.getRegistry(1099);
            // Liaison de l'objet distant (stub) dans le Registre
            reg.rebind("Connection", stub);
            System.out.println("Le Serveur est prêt...");
            Connection connection=new Connection();
            connection.signIn("sourour","Gazzeh");
            connection.login("Imene","Yahiaoui");
            connection.login("sourour","Gazzeh");
        }catch(Exception e){

        }
    }
}
