/**
 * Created by HKoehler on 2/1/17.
 */
public class Config {

    private String url = "jdbc:mysql://localhost/adlister_db";
    private String username = "adlister_user";
    private String password = "password";

    public String getUrl(){
        return url;
    }

    public String getUsername (){
        return username;
    }

    public String getPassword (){
        return password;
    }
}

