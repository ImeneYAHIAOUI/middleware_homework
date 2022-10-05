import contrats.Bill;
import contrats.IClientBox;
import contrats.IVODService;
import contrats.MovieDesc;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class VODService  extends UnicastRemoteObject  implements IVODService  {
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
    public Bill playmovie(String isbn, IClientBox box) {
        List<MovieDesc> movieChoosen=MovieList.stream().filter(movie -> movie.Isbn.equals(isbn)).toList();
         if(!movieChoosen.isEmpty()){
             try{
                 box.stream("Are you ready?".getBytes(StandardCharsets.UTF_8));
             }catch (RemoteException e){
                 new Bill(movieChoosen.get(0).MovieName,0);
             }
             Thread t = new Thread() {
                 public void run() {
                     try{
                         box.stream("Here is the film".getBytes(StandardCharsets.UTF_8));
                         box.stream("ASSBDIJDSJFOSJFPSKSKepzzpepzpezpzpe".getBytes(StandardCharsets.UTF_8));

                     }catch (RemoteException e){
                         new Bill(movieChoosen.get(0).MovieName,0);
                     }}};
             t.start();
             return new Bill(movieChoosen.get(0).MovieName,15);
         }
        return null;

    }

}
