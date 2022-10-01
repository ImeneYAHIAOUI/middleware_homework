package Server;


public class Server
{
    public static void main( String[] args )
    {
        try{
            Connection connection=new Connection();
            connection.signIn("sourour","Gazzeh");
            connection.login("Imene","Yahiaoui");
            connection.login("sourour","Gazzeh");
        }catch(Exception e){

        }
    }
}
