package contrats;
import java.rmi.Remote;

import java.util.List;
public interface IVODService extends Remote {
    public Bill playmovie(String isbn, IClientBox box);
    public List<MovieDesc> viewCatalog();
}
