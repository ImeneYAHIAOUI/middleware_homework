package contrats;

import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;

public class MovieDescExtended extends MovieDesc {
    private byte[] Teaser;

    public MovieDescExtended(String movieName, String isbn, String synopsis, byte[] teaser){
        super(movieName,isbn,synopsis);
        this.Teaser=teaser;
    }
    public MovieDescExtended(String synopsis, byte[] teaser){
        super(synopsis);
        this.Teaser=teaser;
    }
    @Override
    public String affiche() {
        return "Synopsis : "+Synopsis+ "Teaser: " +new String(Teaser, StandardCharsets.UTF_8);
    }

    public byte[] getTeaser() throws RemoteException {
        return Teaser;
    }
}
