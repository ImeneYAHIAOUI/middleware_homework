package contrats;

import java.io.Serializable;

public class MovieDesc implements Serializable {
    public String MovieName;
    public String Isbn;
    public String Synopsis;
    public MovieDesc(String movieName,String isbn,String synopsis){
        this.MovieName=movieName;
        this.Isbn=isbn;
        this.Synopsis=synopsis;
    }
    public MovieDesc(String synopsis){
        this.Synopsis=synopsis;

    }

    public String affiche(){
        return  "Synopsis : "+Synopsis;
    }
}
