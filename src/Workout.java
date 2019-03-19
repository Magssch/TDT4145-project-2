import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Workout extends Connect {

    private Statement statement = null;
    private ResultSet result = null;

    public void get(int n){

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(
                    "select * from Treningsøkt " +
                            "ORDER BY ØktID DESC LIMIT " + n + ";");

            while(result.next()){
                System.out.println("ØktID: " + result.getString(1) +
                        " | Varighet: " + result.getString(4) +
                        " | Dato: " + result.getString(2) +
                        " | Tidspunkt: " + result.getString(3) +
                        " | Notat: " + result.getString(5));
            }
        }
        catch(SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }
    }
}