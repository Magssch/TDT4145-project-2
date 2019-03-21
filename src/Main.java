import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
    	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Velkommen til din treningsdagbok!");
    		
		while (true) {
		
	    	System.out.println( "Velg ønsket funksjon ved å skrive tallet ved siden av ønsket funksjon: \n"
	    			+ "1) \t Registrere nye apparater, øvelser og treningsøkter \n"
	    			+ "2) \t Her finner du informasjon om de n siste treningsøktene \n"
	    			+ "3) \t Her kan du for hver enkelt øvelse se en resultatlogg i et gitt tidsintervall \n"
	    			+ "4) \t Her kan du lage nye øvelsesgrupper og legg øvelser som allerede er i en gruppe \n"
	    			+ "5) \t Her kan du finne ut hvilke øvelser du kan gjøre på et apparat \n"
	    			+ "0) \t Skriv 0 om du ønsker å avslutte programmet");
	    			
	    	int nextFunction = scanner.nextInt();

	    	if (nextFunction == 0) {
	    		break;
	    	}
	    	
	    	if (nextFunction == 1) {
	    		Register r = new Register();
	    		r.connect();
	    		
	    		System.out.println("Ønsker du å registrere en ny treningsøkt (1), et apparat (2) eller en øvelse(3)?");
	    		int option = scanner.nextInt();
	    		if (option == 1) {
					System.out.println("Skriv inn id");
					int id = scanner.nextInt();
	    			System.out.println("Skriv inn dato (format: YYYY-MM-DD)");
	    			String date = scanner.next();
	    			System.out.println("Skriv inn starttidspunkt (format: HHMMSS)");
	    			String time = scanner.next();
	    			System.out.println("Skriv inn varighet i antall minutter");
	    			int duration = scanner.nextInt();
	    			System.out.println("Skriv inn notat");
	    			String notes = scanner.next();
	    			notes += scanner.nextLine();
	    			r.session(id, date, time, duration, notes);
					while(true){
						System.out.println("Skriv inn øvelseID til øvelser som ble gjennomført denne økten. Skriv 0 dersom du er ferdig ");
						int id2 = scanner.nextInt();
						if (id2 == 0){
							break;
						}
						r.sessionInExercise(id2,id);

					}

	    		}
	    		if (option == 2) {

	    			System.out.println("Skriv inn navn");
	    			String name = scanner.next();
	    			System.out.println("Skriv inn beskrivelse");
	    			String description = scanner.next();
	    			r.machine(name, description);


	    		}
	    		if (option == 3) {
	    			System.out.println("Skriv inn navn");
	    			String name = scanner.next();
	    			r.exercise( name);

	    			
	    		}
		    		
		    }
		    	
	    	if (nextFunction == 2) {
	    		Workout workouts = new Workout();
	    	    workouts.connect();
	    		System.out.println("Skriv inn hvor mange økter du har lyst til å se:");
	    		int n = scanner.nextInt();
		 		workouts.get(n);
	    	}
	    	
	    	if (nextFunction == 3) {
	    		System.out.println("Hvilken øvelse ønsker du å se resultatlogg for? ");
	    		String exercise = scanner.next();
	    		System.out.println("Ønsker du å finne tidsintervall basert på dato (velg 1) eller (start)tidspunkt i løpet av en dag (velg 2)?");
	    		int interval = scanner.nextInt();
	    		String start = null;
	    		String finished = null;
	    		if (interval == 1) {
	    			System.out.println("Velg startdato på format YYYY-MM-DD");
	    			start = scanner.next();
	    			System.out.println("Velg sluttdato på format YYYY-MM-DD");
	    			finished = scanner.next();
	    		}
	    		if (interval == 2) {
	    			System.out.println("Velg startid på format HHMMSS");
	    			start = scanner.next();
	    			System.out.println("Velg sluttdato på format HHMMSS");
	    			finished = scanner.next();
	    		}
	    		ResultLog result = new ResultLog();
	    		result.connect();
	    		result.get(exercise, start, finished, interval);
	    	}
		    	
	    	Statement stmt = null;
			ResultSet rs = null;
		    	
	    	if (nextFunction == 4){
	    		newGroup group = new newGroup();
	    		group.connect();
	    		System.out.println("ønsker du å opprette en ny øvelsesgruppe, svar y dersom ja og n dersom nei");
	    		String answer= scanner.next();
	    		if(answer.equals("y")){
	    			System.out.println("Hva heter gruppen du ønsker å lage? ");
		    		String groupName = scanner.next();
		            System.out.println("Hvilke id skal gruppen ha?"); //hadde vært fint om vi listet opp id'er som er opptatt
		    		int id= scanner.nextInt();
		    		scanner.nextLine();
		    		group.InsertExcerciseGroup(id, groupName);
		    		System.out.println("Hvilke øvelser vil du at skal ligge i gruppen, skriv inn id(er)");
		    		group.GetExercises();
		    		System.out.println("Skriv inn id til valgt øvelse, og trykk enter. Når du er ferdig skriv 0");
		    		while (true) {
		    			int newExcercise = scanner.nextInt();
		    			if (newExcercise == 0) {
		    				break;
		    			}
		    			else {
		    				group.InsertExcerciseInGroup(newExcercise, id);
		    			}
		    		}
	    		}
	    		System.out.println("Hvilke Gruppeid ønsker du å se øvelser fra?");
	    		int groupID2= scanner.nextInt();
	    		group.ExcerciseInGroup(groupID2);
	    	}
	    	
	    	if (nextFunction == 5) { 
			    System.out.println("Skriv navnet på apparatet: ");
			    String name = scanner.next();

			    MachineExercise me = new MachineExercise ();
	    	    me.connect();
	    	    me.get(name);
	    	}	    
		}

		scanner.close();
	    System.out.println("Program terminated successfully");
    }
}
