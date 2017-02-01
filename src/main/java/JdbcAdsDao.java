import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.List;

/**
 * Created by HKoehler on 2/1/17.
 */
public class JdbcAdsDao implements Ads{

    private Connection connection;

    // Constructor - creates new driver
    public JdbcAdsDao() throws SQLException {
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        //Establishing connection
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/adlister_db",
                "root",
                "codeup");

        // Above code is similar to doing:
        // mysql -u root -p
        // use database adlister_db;
    }

    @Override
    public List<Ad> all() {
        String sql = "SELECT * FROM ads";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");

                Ad ad = new Ad(id, title, description);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
