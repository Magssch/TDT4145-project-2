
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
		
		String query = "SELECT groupID,navn FROM øvelse INNER JOIN øvelseigruppe ON (øvelse.excerciseID = øvelseigruppe.excerciseID) WHERE groupID="+id+";";
		if (stmt.execute(query)) {
			rs = stmt.getResultSet();
		}
		
		while (rs.next()) {
			String string = rs.getString(1);
			String string2 = rs.getString(2);
			System.out.println(string+ " "+string2);
		}
	}
	catch(SQLException ex) {
		System.out.println("SQLException " + ex.getMessage());
	}
	
}      
	            
	
	public void InsertExcerciseGroup(int groupID, String muscleGroup) {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("INSERT INTO øvelsesGruppe VALUES ("+groupID+",\'"+muscleGroup+"\')");
			System.out.println("gruppe ble lagret");
		}
		catch(SQLException ex) {
			System.out.println("SQLException " + ex.getMessage());
		}
	}
	
	public void InsertExcerciseInGroup(int excerciseID, int groupID) {
		try {
			stmt = connection.createStatement();
			String query = "INSERT INTO øvelseigruppe VALUES(" + groupID + ", "+ excerciseID +");";
			stmt = connection.createStatement();
			stmt.executeUpdate(query);
		}
		catch(SQLException ex) {
			System.out.println("SQLException " + ex.getMessage());
		}
	}
	
	public void GetExcercises() {
		try {
			stmt = connection.createStatement();
			String query = "SELECT * FROM øvelse;";
			if (stmt.execute(query)) {
				rs = stmt.getResultSet();
			}
			
			String row = rightPadding("excerciseID", 15) + rightPadding("Navn på øvelse", 15);
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
		catch(SQLException ex) {
			System.out.println("SQLException " + ex.getMessage());
		}
		
	}
} 
