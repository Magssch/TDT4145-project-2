import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultLog extends Connect {
	
	public static String rightPadding(String str, int num) {
		return String.format("%1$-" + num + "s", str);
	}
	
	public void getResultatLogg(String exercise, String start, String finish, int sortBy) {
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = connection.createStatement();
			//sorter på dato (1) eller starttidspunkter (2)/alle andre tall
			String insatt = null;
			if (sortBy == 1) {
				insatt = "dato";
			}
			else if (sortBy == 2){
                insatt = "tidspunkt"; 
            }
			String query = "SELECT treningsid, navn, dato, tidspunkt, varighet, form, prestasjon, notat " + 
					"FROM (øvelse NATURAL JOIN øvelsepåøkt) NATURAL JOIN treningsøkt " + 
					"WHERE navn = '" + exercise + "' AND " + insatt +" BETWEEN '" + start + "' AND '"
					+ finish +"';";
			if (stmt.execute(query)) {
				rs = stmt.getResultSet();
			}
			String rad = rightPadding("Treningsid", 15) + rightPadding("øvelse", 15) + rightPadding("dato", 15) +
					rightPadding("tidspunkt", 15) + rightPadding("varighet", 15) + 
					rightPadding("form", 15) + rightPadding("prestasjon", 15) + rightPadding("notat", 15);
			
			while (rs.next()) {
				String kolonne = null;
				rad += "\n";
				for (int i = 1; i < 9; i++) {
					kolonne = rs.getString(i);
					rad += rightPadding(kolonne, 15);
				}	
			}
			
			System.out.println(rad);
		}
		catch(SQLException ex) {
			System.out.println("SQLException " + ex.getMessage());
		}
	}
	
}	
