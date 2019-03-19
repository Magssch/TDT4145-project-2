import java.sql.*;
import java.util.Properties;

public class Connect {

    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    protected Connection connection;

    public void connect() {
        try {
            Properties p = new Properties();
            p.put("user", "root");
            p.put("password", "root");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/prosjekt2?autoReconnect=true&useSSL=false", p);
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

