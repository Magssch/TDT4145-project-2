import java.sql.SQLException;
import java.sql.Statement;

public class Register extends Connect {

    private Statement statement = null;

    public void session(String date, String time, int duration, String note) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(
                    "INSERT INTO Treningsøkt(Dato, Tidspunkt, Varighet, Notat) " +
                            "VALUES ('"+ date +"', '"+ time +"', "+ duration +", '" + note + "')");
        }
        catch(SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }
    }


    public void machine(int machineID, String name, String description) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(
                    "INSERT INTO Apparat " +
                            "VALUES (" + machineID + ", '" + name + "', '"  + description + "')");
        }
        catch(SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }
    }

    public void exercise(int exerciseID, String name) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(
                    "INSERT INTO Øvelse " +
                            "VALUES ("+ exerciseIDID + ", '" + name +"')");
        }
        catch(SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }
    }

}
