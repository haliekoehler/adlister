/**
 * Created by HKoehler on 2/1/17.
 */
public class Config {

    public static String url = "jdbc:mysql://localhost/adlister_db";
    public static String username = "adlister_user";
    public static String password = "password";

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

