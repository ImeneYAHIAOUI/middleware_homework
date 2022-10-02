
public class Client {
    private String Password;
    private Boolean Connected = false;

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
