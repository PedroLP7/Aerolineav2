package v2;

import java.util.ArrayList;

public class User {
    private String user;
    private String password;
    private boolean isAdmin;

    private int ticketsOwned;

    public int getTicketsOwned() {
        return this.ticketsOwned;
    }

    public void setTicketsOwned(int ticketsOwned) {
        this.ticketsOwned = ticketsOwned;
    }

    public User(String user, String password, boolean isAdmin, int ticketsOwned) {
        this.user = user;
        this.password = password;
        this.isAdmin = isAdmin;
        this.ticketsOwned = ticketsOwned;
    }


    public User(String user, String password, boolean isAdmin) {
        this.user = user;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public static ArrayList<User> userlist() {
        ArrayList<User> userlist= new ArrayList<>();
        User user1 = new User("Nino","1234",false);
        User user2 = new User("admin", "admin",true);
        User user3= new User("Ivan","1234",true);
        User user4 = new User("Eviam","1234", false);
       userlist.add(user1);
        userlist.add(user2);
       userlist.add(user3);
       userlist.add(user4);
        return userlist;

    }
public void prueba(){
    System.out.println("esto funciona");
}
    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public User() {
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }



}
