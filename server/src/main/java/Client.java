
public class Client {
    private String Password;
<<<<<<< HEAD:1/src/main/java/Server/Client.java
    private Boolean Connected;
=======
    private Boolean Connected = false;

>>>>>>> 59e8e04726d24e6a98bf06bc04bb253bba7f9b84:server/src/main/java/Client.java
    private String Mail;
    public Client(String name, String password){
        this.Password=password;
        this.Mail =name;
    }
    public String GetPassword() {
        return Password;
    }
    public String GetMail(){
        return Mail;
    }

    public Boolean getConnected() {
        return Connected;
    }

    public void setConnected(Boolean status){
        Connected=status;
    }

}
