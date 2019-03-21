import java.sql.*;
import java.util.Properties;

public class Connect {

    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    protected Connection connection;

    public void connect() {
        try {

            Properties p = new Properties();
            p.put("user", "root");
            p.put("password", "");


            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prosjekt2", p);
        } catch (Exception e) {
            throw new RuntimeException("Unable to connect to database", e);
        }
    }

    public void disconnect() {
        try {
            connection.close();
        } catch(SQLException e) {
            System.out.println("Unable to disconnect from database: " + e.toString());
        }
    }
}

