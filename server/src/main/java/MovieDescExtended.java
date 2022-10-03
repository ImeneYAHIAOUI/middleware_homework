import contrats.MovieDesc;

public class MovieDescExtended extends MovieDesc {
    private byte[] Teaser;
    public MovieDescExtended(String movieName,String isbn,String synopsis,byte[] teaser){
        super(movieName,isbn,synopsis);
        this.Teaser=teaser;
    }
    public MovieDescExtended(String synopsis,byte[] teaser){
        super(synopsis);
        this.Teaser=teaser;
    }

    @Override
    public String affiche() {
        return Synopsis+ Teaser.toString();
    }
}
