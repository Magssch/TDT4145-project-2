import java.sql.*;

public class ExerciseOnMachine extends Connect {


    public void ØvelserApparat(String navn) {

        Statement statement = null;
        ResultSet result = null;

        try {
            statement = connection.createStatement();

            String query = "SELECT øvelse.navn FROM øvelsemedapparat Inner Join apparat ON øvelsemedapparat.apparatid = apparat.apparatid Inner Join øvelse ON øvelse.øvelsesid = øvelsemedapparat.øvelsesid WHERE apparat.navn =" + "'" + navn + "'";
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
	