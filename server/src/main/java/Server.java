
import contrats.IConnection;
import contrats.MovieDesc;
import contrats.MovieDescExtended;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server
{
    public static void main( String[] args ) throws RemoteException {
            Connection connection = new Connection();
            connection.VodService.AddMovie(new MovieDesc("Your name","2376320127",
                    "Your Name (Japanese: 君の名は。, Hepburn: Kimi no Na wa) is " +
                            "a 2016 Japanese animated romantic fantasy film produced by CoMix Wave Films" +
                            " and distributed by Toho. It depicts a high school boy in Tokyo " +
                            "and a high school girl in the Japanese countryside who suddenly and " +
                            "inexplicably begin to swap bodies."));
            connection.VodService.AddMovie(new MovieDesc("When marmie was there","1973210533","The film follows Anna Sasaki staying with her relatives in a town in Kushiro wetlands, Hokkaido. " +
                    "Anna comes across a nearby abandoned mansion, where she meets Marnie, a mysterious girl " +
                    "who asks her to promise to keep their secrets from everyone. " +
                    "As the summer progresses, Anna spends more time with Marnie, " +
                    "and eventually Anna learns the truth about her family and foster care."));
        connection.VodService.AddMovie(new MovieDescExtended("Room","12345678","After being abducted seven years ago" +
                " a young woman is held captive in a sparsely furnished and cramped suburban garden shed along " +
                "with her now-kindergarten-aged son. Repeatedly raped and without access " +
                "to the outside world save for a rickety TV with spotty reception, she plots their escape from the monster " +
                "who has imprisoned them. " +
                "This is only a basic blueprint of what unfolds in \"Room,\" an intensely felt cinematic experience","This is the teaser".getBytes()));
            IConnection connectionObject = (IConnection) UnicastRemoteObject.exportObject(connection, 2001);
            Registry registry = LocateRegistry.getRegistry(1099);
            registry.rebind("Connection", connectionObject);
            System.out.println("Server is ready");

    }
}
