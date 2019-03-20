import java.sql.*;

public class MachineExercise extends Connect {


    public void get(String name) {

        Statement statement = null;
        ResultSet result = null;

        try {
            statement = connection.createStatement();

            String query = "SELECT Øvelse.Navn FROM Apparatøvelse " +
                    "Inner Join Apparat ON Apparatøvelse.ApparatID = Apparat.ApparaitID " +
                    "Inner Join Øvelse ON Øvelse.ØvelsesID = Apparatøvelse.ØvelsesID " +
                    "WHERE Apparat.Navn = '" + name + "'";

            if (statement.execute(query)) {
                result = statement.getResultSet();
            }

            while (result.next()) {
                String string = result.getString(1);
                System.out.println(string);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
	
