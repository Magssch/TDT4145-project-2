import java.sql.SQLException;
import java.sql.Statement;

public class Register extends Connect {

    private Statement statement = null;

    public void session(Integer id, String date, String time, int duration, String note) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(
                    "INSERT INTO Treningsøkt(ØktID, Dato, Tidspunkt, Varighet, Notat) " +
                            "VALUES ('" + id + "','"+ date +"', '"+ time +"', "+ duration +", '" + note + "')");
        }
        catch(SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }
    }


    public void machine(String name, String description) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(
                    "INSERT INTO Apparat( Navn, Beskrivelse) " +
                            "VALUES ('" + name + "', '"  + description + "')");
        }
        catch(SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }
    }

    public void exercise(String name) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(
                    "INSERT INTO Øvelse(Navn) " +
                            "VALUES ('" + name +"')");
        }
        catch(SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }


    }
    public void sessionInExercise(Integer id1, Integer id2) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(
                    "INSERT INTO ØvelseIØkt(ØvelseID, ØktID) " +
                            "VALUES ('" + id1 +"','" + id2 +"')");
        }
        catch(SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }


    }


}
