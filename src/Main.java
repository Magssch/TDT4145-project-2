//Må vi skrive package her? 
package prosjeckt2-db;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import prosjekt2-db.ExcerciceOnMachine;
import prosjekt2-db.ResultLog;

public class Main {
	
    public static void main(String[] args) {
    	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Velkommen til din treningsdagbok!");
    		
		while (true) {
		
	    	System.out.println( "Velg ønsket funksjon ved å skrive tallet ved siden av ønsket funksjon: \n"
	    			+ "1) \t Registrere nye apparater, øvelser og treningsøkter \n"
	    			+ "2) \t Her finner du informasjon om de n siste treningsøktene \n"
	    			+ "3) \t Her kan du for hver enkelt øvelse se en resultatlogg i et gitt tidsintervall \n"
	    			+ "4) \t Her kan du lage nye øvelsesgrupper og hvilke øvelser som allerede er i en gruppe \n"
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
	    		int funk = scanner.nextInt();
	    		if (funk == 1) {
	    			System.out.println("Skriv inn dato (format: YYYY-MM-DD)");
	    			String dato = scanner.next();
	    			System.out.println("Skriv inn starttidspunkt (format: HHMMSS)");
	    			String tidspunkt = scanner.next();
	    			System.out.println("Skriv inn varighet i antall minutter");
	    			int varighet = scanner.nextInt();
                    //hva skal egentlig form bety? tenker vi kan endre til dette: "skriv inn formen du følte du var i fra 1-10"
	    			System.out.println("Skriv inn form (tall fra 1-10");
	    			int form = scanner.nextInt();
	    			System.out.println("Skriv inn prestasjon (tall fra 1-10)");
	    			int prestasjon = scanner.nextInt();
	    			System.out.println("Skriv inn notat");
	    			String notat = scanner.next();
	    			notat += scanner.nextLine();
	    			r.registrer_treningsokt(dato, tidspunkt, varighet, form, prestasjon, notat);
	    		}
	    		if (funk == 2) {
	    			System.out.println("Skriv inn apparatid");
	    			int id = scanner.nextInt();
	    			System.out.println("Skriv inn navn");
	    			String navn = scanner.next();
	    			System.out.println("Skriv inn beskrivelse");
	    			String besk = scanner.next();
	    			r.registrer_aparat(id, navn, besk);
	    		}
	    		if (funk == 3) {
	    			System.out.println("Skriv inn øvelsesid");
	    			int id = scanner.nextInt();
	    			System.out.println("Skriv inn navn");
	    			String navn = scanner.next();
	    			r.registrer_ovelse(id, navn);
	    			
	    		}
		    		
		    }
		    	
	    	if (nextFunction == 2) {
	    		printWorkouts workouts = new printWorkouts();
	    	    workouts.connect();
	    		System.out.println("Skriv inn hvor mange økter du har lyst til å se:");
	    		int n = scanner.nextInt();
		 		workouts.printWorkouts(n);
	    	}
	    	
	    	if (nextFunction == 3) {
	    		System.out.println("Hvilken øvelse ønsker du å se resultatlogg for? ");
	    		String excercise = scanner.next();
	    		System.out.println("Ønsker du å finne tidsintervall basert på dato (velg 1) eller (start)tidspunk i løpet av en dag (velg 2)?");
	    		int interval = scanner.nextInt();
	    		String start = null;
	    		String finished = null;
	    		if (interval == 1) {
	    			System.out.println("Velg startdato på format YYYY-MM-DD");
	    			start = scanner.next();
	    			System.out.println("Velg sluttdato på format YYYY-MM-DD");
	    			finished = scanner.next();
	    		}
	    		if (intervall == 2) {
	    			System.out.println("Velg startid på format HHMMSS");
	    			start = scanner.next();
	    			System.out.println("Velg sluttdato på format HHMMSS");
	    			finished = scanner.next();
	    		}
	    		ResultLog result = new ResultLog();
	    		result.connect();
	    		result.getResultatLogg(øvelse, start, finished, interval);
	    	}
		    	
	    	Statement stmt = null;
			ResultSet rs = null;
		    	
	    	if (nextFunction == 4){
	    		newGroup group = new newGroup();
	    		group.connect();
	    		System.out.println("ønsker du å opprette en ny muskelgruppe, svar y dersom ja og n dersom nei");
	    		String answer= scanner.next();
	    		if(answer.equals("y")){
	    			System.out.println("Hvilke musklgruppe ønsker du å lage en gruppe for? "); 
		    		String groupName = scanner.next();
		            System.out.println("Hvilke id skal muskelgruppen ha?"); //hadde vært fint om vi listet opp id'er som er opptatt
		    		int id= scanner.nextInt();
		    		scanner.nextLine(); //denne lå her i koden fra før, men tror vi må fjerne det. Jeg skjønner ihvertfall ikke hva den gjør -Erling
		    		group.insettØvelseGruppe(id, gruppeNavn);
		    		System.out.println("Hvilke øvelser vil du at skal ligge i gruppen, skriv inn id(er)");
		    		group.getExcercises();
		    		System.out.println("Velg en øvelse, og trykk enter. Når du er ferdig kan skriv 0");
		    		while (true) {
		    			int newExcercise = scanner.nextInt();
		    			if (newExcercise == 0) {
		    				break;
		    			}
		    			else {
		    				p.insettØvelserIGruppen(nyØvelse, id);
		    			}
		    		}
	    		}
	    		System.out.println("Hvilke Gruppeid ønsker du å se øvelser fra?");
	    		int gruppeId2= scanner.nextInt();
	    		p.ØvelseIgruppe(gruppeId2);
	    	}
	    	
	    	if (nextFunction == 5) { 
			    System.out.println("Skriv navnet på apparatet: ");
			    String name = scanner.next();
			    
			    ExcerciseMachine excericeMachine = new ExcerciseMachine ();
	    	    excerciseMachine.connect();
	    	    excerciseMachine.ExcerciseMachine(name);
	    	}	    
		}
		
	    System.out.println("Programmet er nå avsluttet");
		scanner.close();
    }
}
