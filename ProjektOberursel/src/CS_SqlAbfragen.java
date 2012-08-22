import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;



public class CS_SqlAbfragen {
	public CS_SqlAbfragen(){}
	

	//Sql Abfragen zur Helferpage
	static String helfersql()
	{
		String sql = "";
		sql = "SELECT person_id, eintrittsdatum, vname, nachname, geschlecht, strasse, PLZ, Ort, geburtsdatum, telefonnr, handyNr, eMailAdresse " +
				"FROM Person " +
				"LEFT JOIN natPerson ON natPerson.Person_person_id = Person.person_id " +
				"LEFT JOIN Helfer ON natPerson.Person_person_id = Helfer.natPerson_Person_person_id " +
				"WHERE natPerson.Person_person_id = Helfer.natPerson_Person_person_id";
		
		return sql;
	}
	
	static String helferdetailssql(String id)
	{
		String sql = "";
		sql = "SELECT natPerson.vname, natPerson.nachname, Person.strasse, Person.PLZ, Person.Ort, Person.telefonnr, Person.handyNr, Person.eMailAdresse, natPerson.notizen " +
				"FROM Person, natPerson " +
				"WHERE Person.person_id ="+id+" " +
						"AND Person.person_id = natPerson.Person_person_id";
		return sql;
	}
	
	static boolean helferanlegensql(ArrayList<ArrayList<String>> input)
	{
		try{
		String sql = "";		
		String database = "INSERT INTO Person (person_id";
		String values = "VALUES ("+input.get(0).get(1);
		for(int i = 1; i<=6; i++){
			if(!input.get(i).get(1).equals("") && !input.get(i).get(1).equals("''")){
				database += (" ,"+input.get(i).get(0));
				values += (" ,"+input.get(i).get(1));						
			}
		}
		database += ") ";
		values += ")";
		sql = database + values;
		if(!sql.equals(""))
			if(!CS_DataBaseConnect.dbUpdate(sql))
				return false;
		
		database = "INSERT INTO natPerson (natPerson.notizen, Person_person_id";
		values = "VALUES ('Notizfeld:', "+input.get(0).get(1);
		for(int i = 7; i<=11; i++){
			if(!input.get(i).get(1).equals("") && !input.get(i).get(1).equals("''")){
				database += (" ,"+input.get(i).get(0));
				values += (" ,"+input.get(i).get(1));				
			}
		}
		database += ") ";
		values += ")";
		sql = database + values;
		if(!sql.equals(""))
			if(!CS_DataBaseConnect.dbUpdate(sql))
				return false;
		
		database = "INSERT INTO Helfer (natPerson_Person_person_id";
		values = "VALUES ("+input.get(0).get(1);
		
		if(!input.get(12).get(1).equals("") && !input.get(12).get(1).equals("''")){
			database += (" ,"+input.get(12).get(0));
			values += (" ,"+input.get(12).get(1));					
		}
		database += ") ";
		values += ")";
		sql = database + values;
		if(!sql.equals(""))
			if(!CS_DataBaseConnect.dbUpdate(sql))
				return false;
		
		int t = input.size();
		for(int i = 13; i < t; i++){
			database = "INSERT INTO helfer_faehigkeit_zuordnung (Helfer_natPerson_Person_person_id";
			values = "VALUES ("+input.get(0).get(1);
			
				if(!input.get(i).get(1).equals("") && !input.get(i).get(1).equals("''")){
					database += (" ,"+input.get(i).get(0));
					values += (" ,"+input.get(i).get(1));				
				}
			
			database += ") ";
			values += ")";
			sql = database + values;
			if(!sql.equals(""))
			if(!CS_DataBaseConnect.dbUpdate(sql))
				return false;				
		}
		
		return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	static boolean einsatzanlegensql(ArrayList<String> input)
	{
		try {
			String sql = "";		
			String database = "INSERT INTO Einsatz (Aufgabe_id, beginnDatum, EndDatum, Helfer_natPerson_Person_person_id)";
			String values = "VALUES ("+input.get(0);
			for(int i = 1; i<=input.size()-1; i++){
				if(!input.get(i).equals("") && !input.get(i).equals("''")){
					values += (" ,"+input.get(i));						
				}
			}
			values += ")";
			sql = database + values;
			if(!sql.equals(""))
			if (CS_DataBaseConnect.dbUpdate(sql))
				return true;
		
	
			return false;
		}
		catch(Exception ex)
		{
			return false;
		}	
	}
	
	
	static String passwortermittelnsql(String vName, String nName)
	{
		String sql = "";
		sql = "SELECT login.passwort FROM login, Lotse, natPerson WHERE login.Lotse_natPerson_Person_person_id = Lotse.natPerson_Person_person_id AND Lotse.natPerson_Person_person_id = natPerson.Person_person_id AND natPerson.vname = "+vName+" AND natPerson.nachname = "+nName;
		return sql;
	}
	
	static String einsatzfuerhelferanzeigensql(String id)
	{
		String sql = "";		
		sql = "SELECT DISTINCT Einsatz.beginnDatum, Einsatz.endDatum, Aufgabe.name, faehigkeit.bezeichnung, faehigkeit.faehigkeit_id, Traeger.name " +
				"FROM helfer_faehigkeit_zuordnung, faehigkeit, faehigkeit_aufgabe_zuordnung, Aufgabe, Traeger_Aufgabe_Zuordnung, Traeger, Einsatz " +
				"WHERE Einsatz.Helfer_natPerson_Person_person_id ="+id+" " +
						"AND Einsatz.Aufgabe_id = Aufgabe.Aufgabe_id " +
						"AND Aufgabe.Aufgabe_id = Traeger_Aufgabe_Zuordnung.Aufgabe_id " +
						"AND Aufgabe.Aufgabe_id = faehigkeit_aufgabe_zuordnung.Aufgabe_id " +
						"AND helfer_faehigkeit_zuordnung.faehigkeit_id = faehigkeit.faehigkeit_id " +
						"AND faehigkeit_aufgabe_zuordnung.faehigkeit_id = faehigkeit.faehigkeit_id " +
						"AND Traeger_Aufgabe_Zuordnung.Traeger_Person_person_id = Traeger.Person_person_id " +
						"AND Einsatz.beginnDatum > CURDATE( ) " +
						"ORDER BY Einsatz.beginnDatum";		
		return sql;
		
	}
	

	
	
	static String faehigkeitenhelfersql(String id)
	{
		String sql = "SELECT faehigkeit.bezeichnung FROM faehigkeit, helfer_faehigkeit_zuordnung where helfer_faehigkeit_zuordnung.faehigkeit_id = faehigkeit.faehigkeit_id AND helfer_faehigkeit_zuordnung.Helfer_natPerson_Person_person_id = "+id;
		return sql;
	}
	
	static String aufgabenHelfersql(String id)
	{
		String sql = "";
		sql = "SELECT Aufgabe.Aufgabe_id, Aufgabe.name, Aufgabe.beschreibung, Traeger.name, Aufgabe.AufgabeBeginn, Aufgabe.AufgabeEnde, Aufgabe.einsatzAnlegen " +
				"FROM Aufgabe, faehigkeit_aufgabe_zuordnung, faehigkeit, helfer_faehigkeit_zuordnung, Helfer, Traeger_Aufgabe_Zuordnung, Traeger " +
				"WHERE Aufgabe.Aufgabe_id = faehigkeit_aufgabe_zuordnung.Aufgabe_id " +
				"AND faehigkeit_aufgabe_zuordnung.faehigkeit_id = faehigkeit.faehigkeit_id " +
				"AND faehigkeit.faehigkeit_id = helfer_faehigkeit_zuordnung.faehigkeit_id " +
				"AND helfer_faehigkeit_zuordnung.Helfer_natPerson_Person_person_id = Helfer.natPerson_Person_person_id " +
				"AND Aufgabe.Aufgabe_id = Traeger_Aufgabe_Zuordnung.Aufgabe_id " +
				"AND Traeger_Aufgabe_Zuordnung.Traeger_Person_person_id = Traeger.Person_person_id " +
				"AND Helfer.natPerson_Person_person_id ="+id+" " +
				"GROUP BY Aufgabe.Aufgabe_id";
		
		return sql;
	}
	
	static boolean einsatzfuerhelferdeletesql()
	{
		try{
			String sql = "";
			
			return true;	
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	static boolean faehigkeitenupdatesql(ArrayList<String> input, String id)
	{
		try{
		String sql = "";
		sql = "DELETE FROM helfer_faehigkeit_zuordnung where Helfer_natPerson_Person_person_id = "+id;
		if(!sql.equals(""))
			if(!CS_DataBaseConnect.dbUpdate(sql))
				return false;	
		
		sql = "";
		int t = input.size();
		for(int i = 0; i < t; i++){
			String database = "INSERT INTO helfer_faehigkeit_zuordnung (Helfer_natPerson_Person_person_id, faehigkeit_id";
			String values = "VALUES ("+id;
			
				if(!input.get(i).equals("") && !input.get(i).equals("''")){
					values += (" ,"+input.get(i));				
				}
			
			database += ") ";
			values += ")";
			sql = database + values;
			if(!sql.equals(""))
			if(!CS_DataBaseConnect.dbUpdate(sql))
				return false;	
			
		}
			
			return true;	
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	static boolean updatenotizensql(String notizen, String id)
	{
		try{
		
				String sql = "UPDATE natPerson SET notizen = '"+notizen+"' WHERE natPerson.Person_person_id = "+id;
			
				if(!sql.equals(""))
				if(!CS_DataBaseConnect.dbUpdate(sql))
					return false;	
				
				return true;	
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	
	
	//Sql Abfragen zur Trägerpage
	static String traegersql()
	{
		String sql = "";
		sql = "SELECT Traeger.Person_person_id, Traeger.name, Traeger.rechtsform, Traeger.beschreibung FROM Traeger";
		return sql;
	}
	//Sql Abfragen zur Aufgabenpage
	static String aufgabensql()
	{
		String sql = "SELECT Aufgabe.Aufgabe_id, Aufgabe.name, Aufgabe.beschreibung FROM Aufgabe";
		return sql;

	}
	
	//Sql Abfragen zur Fähigkeitenpage
	static String faehigkeitensql()
	{
		String sql = "SELECT faehigkeit.bezeichnung, faehigkeit.faehigkeit_id FROM faehigkeit";
		return sql;

	}
	

}
