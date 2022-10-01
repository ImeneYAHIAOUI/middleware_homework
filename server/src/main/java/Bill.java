package Server;

import java.io.Serializable;
import java.math.BigInteger;

public class Bill implements Serializable {
    String movieName;
    int outrageousPrice;
    public Bill(String name, int price){
        this.movieName=name;
        this.outrageousPrice=price;
    }
}
