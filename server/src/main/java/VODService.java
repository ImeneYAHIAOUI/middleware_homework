import contrats.Bill;
import contrats.IClientBox;
import contrats.IVODService;
import contrats.MovieDesc;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class VODService  extends UnicastRemoteObject implements IVODService {
    List<MovieDesc>  MovieList=new ArrayList<MovieDesc>();
    protected VODService() throws RemoteException {
    }
    public void AddMovie(MovieDesc movie){
        MovieList.add(movie);
    }
    @Override
    public List<MovieDesc> viewCatalog(){
        return MovieList;
    }
     @Override
    public Bill playmovie(String isbn, IClientBox box){
        List<MovieDesc> movieChoosen=MovieList.stream().filter(movie -> movie.Isbn.equals(isbn)).toList();
        if(!movieChoosen.isEmpty()) return new Bill(movieChoosen.get(0).MovieName,15);
        return null;
    }

}
