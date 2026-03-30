package Model;
import Enums.*;

public class User {
    public String name;
    public int phoneNumber;
    public boolean isMale;
    public String email;

    public User(String name , int phoneNumber, boolean isMale, String email){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isMale = isMale;
        this.email = email;
    }
}
