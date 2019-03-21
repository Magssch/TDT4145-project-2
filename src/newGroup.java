
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class newGroup extends Connect {
	
	Statement stmt = null;
	ResultSet rs = null;
	
	public static String rightPadding(String str, int num) {
		return String.format("%1$-" + num + "s", str);
	}
	
	public void ExcerciseInGroup(int id){
		
	try {
		stmt = connection.createStatement();
		
		String query = "SELECT GruppeID , Øvelse.Navn FROM Øvelse INNER JOIN " +
				"ØvelseIGruppe ON (Øvelse.ØvelseID = ØvelseIGruppe.ØvelseID) WHERE GruppeID=" + id + ";";
		if (stmt.execute(query)) {
			rs = stmt.getResultSet();
		}
		
		while (rs.next()) {
			String string = rs.getString(1);
			String string2 = rs.getString(2);
			System.out.println(string+ " "+ string2);
		}
	}
	catch(SQLException e) {
		System.out.println("SQLException " + e.getMessage());
	}
	
}      
	            
	
	public void InsertExcerciseGroup(Integer id, String muscleGroup) {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("INSERT INTO Øvelsesgruppe(GruppeID,Navn)" +
					" VALUES ('" + id + "','" + muscleGroup + "')");
			System.out.println("gruppen ble lagret");
		}
		catch(SQLException e) {
			System.out.println("SQLException " + e.getMessage());
		}
	}
	
	public void InsertExcerciseInGroup(int excerciseID, int groupID) {
		try {
			stmt = connection.createStatement();
			String query = "INSERT INTO ØvelseIGruppe(ØvelseID, GruppeID)" +
					" VALUES(" + excerciseID  + ", "+ groupID +");";
			stmt = connection.createStatement();
			stmt.executeUpdate(query);
		}
		catch(SQLException e) {
			System.out.println("SQLException " + e.getMessage());
		}
	}
	
	public void GetExercises() {
		try {
			stmt = connection.createStatement();
			String query = "SELECT * FROM Øvelse;";
			if (stmt.execute(query)) {
				rs = stmt.getResultSet();
			}
			
			String row = rightPadding("Excercise ID: ", 15) + rightPadding("Navn på øvelse: ", 15);
			while (rs.next()) {
				String column = null;
				row += "\n";
				for (int i = 1; i < 3; i++) {
					column = rs.getString(i);
					row += rightPadding(column, 15);
				}	
			}
			System.out.println(row);
		}
		catch(SQLException e) {
			System.out.println("SQLException " + e.getMessage());
		}
		
	}
} 
