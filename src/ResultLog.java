import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultLog extends Connect {
	
	public static String rightPadding(String s, int n) {
		return String.format("%1$-" + n + "s", s);
	}
	
	public void get(String exercise, String start, String finish, int sortBy) {
		Statement statement = null;
		ResultSet result = null;
		
		try {
			statement = connection.createStatement();
			String sorting = null;

			if (sortBy == 1) {
				sorting = "Dato";
			}
			else if (sortBy == 2){
                sorting = "Tidspunkt";
            }
			String query = "SELECT ØktID, Navn, Dato, Tidspunkt, Varighet, Notat " +
					"FROM (Øvelse NATURAL JOIN ØvelseIØkt) NATURAL JOIN Treningsøkt " +
					"WHERE Navn = '" + exercise + "' AND " + sorting +" BETWEEN '" + start + "' AND '"
					+ finish +"';";
			if (statement.execute(query)) {
				result = statement.getResultSet();
			}
			String row = rightPadding("Økt ID: ", 15) + rightPadding("Øvelse: ", 15) + rightPadding("Dato: ", 15) +
					rightPadding("Tidspunkt: ", 15) + rightPadding("Varighet: ", 15) + rightPadding("Notat: ", 15);
			
			while (result.next()) {
				String col = null;
				row += "\n";
				for (int i = 1; i < 9; i++) {
					col = result.getString(i);
					row += rightPadding(col, 15);
				}	
			}
			
			System.out.println(row);
		}
		catch(SQLException e) {
			System.out.println("SQLException " + e.getMessage());
		}
	}
	
}	
