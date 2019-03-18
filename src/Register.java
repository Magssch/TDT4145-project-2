import java.sql.SQLException;
import java.sql.Statement;

public class Register extends Connect {

    private Statement statement = null;

    public void treningsokt(String dato, String tidspunkt, int varighet, int form, int prestasjon, String notat) {
        try {
            statement = conn.createStatement();
            statement.executeUpdate(
                    "INSERT INTO Treningsøkt(Dato, Tidspunkt, Varighet, Notat) "
                    + "VALUES ('"+dato+"', '"+tidspunkt+"', "+varighet+", '" + notat + "')");
        }
        catch(SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }
    }


    public void apparat(int apparatid, String navn, String beskrivelse) {
        try {
            statement = conn.createStatement();
            statement.executeUpdate(
                    "INSERT INTO apparat "
                    + "VALUES (" + apparatid + ", '" + navn + "', '"  +beskrivelse + "')");
        }
        catch(SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }
    }

    public void ovelse(int ovelsesid, String navn) {
        try {
            statement = conn.createStatement();
            statement.executeUpdate(
                    "INSERT INTO øvelse "
                    + "VALUES ("+ ovelsesid + ", '" +navn+"')");
        }
        catch(SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }
    }



}