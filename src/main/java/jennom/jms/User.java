package jennom.jms;

import java.io.Serializable;

public class User implements Serializable {
    
    private String login;
    private String passw;
    
    /*public User (String login, String passw) {
       this.login=login;
       this.passw=passw;
    }*/

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }
    
}
