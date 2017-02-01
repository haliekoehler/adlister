import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HKoehler on 2/1/17.
 */
public class MySQLAdsDAO implements Ads{

    private Connection connection;

    public MySQLAdsDAO(Config config) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );
    }

    // get a list of all the ads
    public List<Ad> all() throws SQLException {

        // select * from ads
        String sql = "SELECT * FROM ads";

        //create a new List
        List<Ad> ads = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // add a new Ad object to the ads List inside this loop

            // use the rs.getLong(), getString, methods to grab values from the row (in the db)
            // use those values to instantiate a new Ad object, passing them to the constructor
            // add that new Ad object to the ads arrayList

            long id = resultSet.getLong("id");
            long userId = resultSet.getLong("user_id");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");

            Ad ad = new Ad(id, userId, title, description);

            ads.add(ad);
        }

        return ads;
    }

    // insert a new ad and return the new ad's id
    public Long insert(Ad ad) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(createInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        return rs.getLong(1);
        // insert into ads (col 1, col 2, col3) values (val1, val2, val3)
    }

    private String createInsertQuery(Ad ad) {
        return "INSERT INTO ads(user_id, title, description) VALUES "
                + "(" + ad.getUserId() + ", "
                + "'" + ad.getTitle() +"', "
                + "'" + ad.getDescription() + "')";
    }

//
//    public Ad find(int id){
//        // select
//    }
}
