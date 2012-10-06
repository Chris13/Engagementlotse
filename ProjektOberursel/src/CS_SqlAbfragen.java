import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class CS_SqlAbfragen {
	public CS_SqlAbfragen(){}
	

	//Sql Abfragen zur Helferpage------------------------------------------------------------------------------------------------------------------------------------------------
	//Anzeige der Helferinformationen im JTable des Helferpanel
	static String helfersql()
	{
		String sql = "";
		sql = "SELECT eintrittsdatum, titel, vname, nachname, geschlecht, strasse, PLZ, Ort, geburtsdatum, telefonnr, handyNr, eMailAdresse, person_id " +
				"FROM Person " +
				"LEFT JOIN natPerson ON natPerson.Person_person_id = Person.person_id " +
				"LEFT JOIN Helfer ON natPerson.Person_person_id = Helfer.natPerson_Person_person_id " +
				"WHERE natPerson.Person_person_id = Helfer.natPerson_Person_person_id";
		
		return sql;
	}
	
	//Abfrage für das Dialogfeld Dialog_HelferAnzeigen
	static String helferdetailssql(String id)
	{
		String sql = "";
		sql = "SELECT natPerson.vname, natPerson.nachname, Person.strasse, Person.PLZ, Person.Ort, Person.telefonnr, Person.handyNr, Person.eMailAdresse, natPerson.notizen FROM Person, natPerson WHERE Person.person_id ="+id+" AND Person.person_id = natPerson.Person_person_id";
		return sql;
	}
	
	//Insert für das Dialogfeld Dialog_HelferAnlegen
	static boolean helferanlegensql(ArrayList<ArrayList<String>> input)
	{
		try{
			
			String sql = "";	
			boolean firstEntry = true;
			String database = "INSERT INTO Person (";
			String values = "VALUES (";
			for(int i = 0; i<=5; i++){
				if(firstEntry)
				{
					if(!input.get(i).get(1).equals("") && !input.get(i).get(1).equals("''")){
						database += input.get(i).get(0);
						values += input.get(i).get(1);
						firstEntry = false;
					}
				}
				else
				{
					if(!input.get(i).get(1).equals("") && !input.get(i).get(1).equals("''")){
						database += (" ,"+input.get(i).get(0));
						values += (" ,"+input.get(i).get(1));						
					}
				}
				
			}
			database += ") ";
			values += ")";
			sql = database + values;
			if(!sql.equals(""))
				if(!CS_DataBaseConnect.dbUpdate(sql))
					return false;
			
			sql = "";		
			CS_DataBaseConnect.dbQuery("SELECT max(person_id) FROM Person",false);	
			DefaultTableModel model = new DefaultTableModel();
			model = CS_DataBaseConnect.getModel();
			int maxId = (Integer.parseInt(model.getValueAt(0, 0).toString()));
			
			database = "INSERT INTO natPerson (natPerson.notizen, Person_person_id";
			values = "VALUES ('Notizfeld:', "+(maxId);
			for(int i = 6; i<=10; i++){
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
			values = "VALUES ("+(maxId);
			
			if(!input.get(11).get(1).equals("") && !input.get(11).get(1).equals("''")){
				database += (" ,"+input.get(11).get(0));
				values += (" ,"+input.get(11).get(1));					
			}
			database += ") ";
			values += ")";
			sql = database + values;
		
			if(!sql.equals(""))
				if(!CS_DataBaseConnect.dbUpdate(sql))
					return false;
			
			int t = input.size();
			for(int i = 12; i < t; i++){
				database = "INSERT INTO helfer_faehigkeit_zuordnung (Helfer_natPerson_Person_person_id";
				values = "VALUES ("+(maxId);
				
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
	
	//Insert für das Dialogfeld Dialog_AufgabefuerHelfer
	static boolean einsatzanlegensql(ArrayList<ArrayList<String>> uebergabeWerte)
	{
		try {
			String sql = "";		
			String database = "INSERT INTO Einsatz (Projekt_Aufgabe_Zuordnung_Aufgabe_id,Projekt_Aufgabe_Zuordnung_Projekt_idProjekt";
			String values = "VALUES ("+uebergabeWerte.get(0).get(1)+","+uebergabeWerte.get(1).get(1);
			for(int i = 2; i<uebergabeWerte.size(); i++){
				if(!uebergabeWerte.get(i).get(1).equals("") && !uebergabeWerte.get(i).get(1).equals("''")){
					database += (" ,"+uebergabeWerte.get(i).get(0));
					values += (" ,"+uebergabeWerte.get(i).get(1));				
				}
			}
			database += ") ";
			values += ")";
			sql = database + values;
			if(!sql.equals(""))
			if (!CS_DataBaseConnect.dbUpdate(sql))
				return false;

			sql = "";		
			database = "INSERT INTO Traeger_Projekt_Zuordnung (Traeger_Person_person_id ,Projekt_idProjekt";
			values = "VALUES ("+uebergabeWerte.get(5).get(1)+","+uebergabeWerte.get(1).get(1);
			
			database += ") ";
			values += ")";
			sql = database + values;
			if(!sql.equals(""))
			CS_DataBaseConnect.dbUpdate(sql);
	
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}	
	}
	
	//Insert für das Dialogfeld Dialog_AufgabefuerHelfer (Einsatzzeiten)
	static boolean einsatzzeitanlegensql(ArrayList<ArrayList<String>> uebergabeWerte, String einsatzID)
	{
		try {
			String sql = "";
			sql = "Select * from Termine";
			if (CS_DataBaseConnect.dbQuery(sql,false))
			{
				DefaultTableModel mdlEinsatzZeit = new DefaultTableModel();
				mdlEinsatzZeit = CS_DataBaseConnect.getModel();
				for(int u = 0; u< uebergabeWerte.get(0).size(); u++)
				{
					String tag = uebergabeWerte.get(0).get(u).substring(0,2);
					String zeit[] = uebergabeWerte.get(0).get(u).substring(4).split("-");
					String zeitStart = zeit[0].substring(0, 5)+":00";
					String zeitEnd = zeit[1].substring(1)+":00";
					int zeitvorhanden = 0;
					for(int z = 0; z < mdlEinsatzZeit.getRowCount();z++)
					{
						if(mdlEinsatzZeit.getValueAt(z, 1) != null && mdlEinsatzZeit.getValueAt(z, 2) != null && mdlEinsatzZeit.getValueAt(z, 3) != null)
							if(zeitStart.equals(mdlEinsatzZeit.getValueAt(z, 1).toString()) && zeitEnd.equals(mdlEinsatzZeit.getValueAt(z, 2).toString()) && tag.equals(mdlEinsatzZeit.getValueAt(z, 3).toString()))
								zeitvorhanden++;					
					}
					
					if(zeitvorhanden == 0)
					{
						sql = "";
						sql = "Insert into Termine (Termine.Startzeit,Termine.Endezeit, Termine.Wochentag ) values ('"+zeitStart+"','"+zeitEnd+"','"+tag+"')";
						if (!CS_DataBaseConnect.dbUpdate(sql))
							JOptionPane.showMessageDialog(null,"Einsatzzeit konnte nicht angelegt werden!","Titel", JOptionPane.ERROR_MESSAGE);
					}
					
					sql = "";
					sql = "Select idTermine from Termine where Termine.Startzeit='"+zeitStart+"' AND Termine.Endezeit='"+zeitEnd+"' AND Termine.Wochentag='"+tag+"'";
					if (CS_DataBaseConnect.dbQuery(sql,false))
					{
						DefaultTableModel mdlZeit = new DefaultTableModel();
						mdlZeit = CS_DataBaseConnect.getModel();
						sql = "";
						sql = "Insert into einsatz_has_termine (Einsatz_id,Termine_idTermine) values ("+einsatzID+","+mdlZeit.getValueAt(0, 0).toString()+")";
						if (!CS_DataBaseConnect.dbUpdate(sql))
							JOptionPane.showMessageDialog(null,"Einsatzzeit konnte nicht angelegt werden!","Titel", JOptionPane.ERROR_MESSAGE);
					}
				}			
			}
		}	
		catch(Exception ex)
		{
			return false;
		}
		return true;	
		
	}
	
	

	//Abfrage für die JComboBox in den JTables zur Auswahl vom Trägern
	static String traegerfuercomboboxnsql()
	{
		String sql = "";
		sql = "SELECT Traeger.name, Traeger.Person_person_id from Traeger";
		return sql;
	}
	
	//Abfrage in den Dialogen Dialog_AufgabefürHelfer und Dialog_HelferfuerAufgabe zur Anzeige der bereits erstellten Einsätze zu einem Helfer
	static String einsatzfuerhelferanzeigensql(String id)
	{
		String sql = "";		
		sql = "SELECT DISTINCT Projekt.projektname, Aufgabe.name, Traeger.name, Einsatz.EinsatzBeginn, Einsatz.EinsatzEnde, Projekt.DummyUhrzeit, Einsatz.EinsatzBeschreibung, Einsatz.Einsatz_id " +
				"FROM Einsatz, Projekt_Aufgabe_Zuordnung, Aufgabe, Projekt, Traeger_Projekt_Zuordnung, Traeger " +
				"WHERE Einsatz.Helfer_natPerson_Person_person_id ="+id+"" +
						" AND Einsatz.Traeger_Person_person_id = Traeger.Person_person_id " +
						"AND Einsatz.Projekt_Aufgabe_Zuordnung_Projekt_idProjekt = Projekt_Aufgabe_Zuordnung.Projekt_idProjekt " +
						"AND Einsatz.Projekt_Aufgabe_Zuordnung_Aufgabe_id = Projekt_Aufgabe_Zuordnung.Aufgabe_id " +
						"AND Projekt_Aufgabe_Zuordnung.Aufgabe_id = Aufgabe.Aufgabe_id " +
						"AND Projekt_Aufgabe_Zuordnung.Projekt_idProjekt = Projekt.idProjekt";		
		return sql;
		
	}
	
	//Abfrage zur Ermittlung der Fähigkeiten zu einem Helfer
	static String faehigkeitenhelfersql(String id)
	{
		String sql = "SELECT faehigkeit.bezeichnung FROM faehigkeit, helfer_faehigkeit_zuordnung where helfer_faehigkeit_zuordnung.faehigkeit_id = faehigkeit.faehigkeit_id AND helfer_faehigkeit_zuordnung.Helfer_natPerson_Person_person_id ="+id;
		return sql;
	}
	
	//Abfrage zur Ermittlung aller Einsatztermine zu einem angelegten Einsatz
	static String einsatzterminesql(String id)
	{
		String sql = "SELECT Wochentag, Startzeit, Endezeit FROM Termine, Einsatz_has_Termine, Einsatz WHERE Einsatz.Einsatz_id ="+id+" AND Einsatz.Einsatz_id = Einsatz_has_Termine.Einsatz_id AND Einsatz_has_Termine.Termine_idTermine = Termine.idTermine";
		return sql;
	}
	
	//Abfrage zur Ermittlung der Fähigkeiten zur Anzeige in der JComboBox
	static String faehigkeitenfuercomboboxsql()
	{
		String sql = "SELECT faehigkeit.bezeichnung, faehigkeit.faehigkeit_id FROM faehigkeit";
		return sql;
	}
	
	//Abfrage zur Filterung aller möglichen Aufgaben die ein Helfer machen kann
	static String aufgabenHelfersql(String id)
	{
		String sql = "";
		sql = "SELECT DISTINCT Projekt.projektname, Aufgabe.name, Projekt.DummyTraeger, Projekt.DummyBeginn, Projekt.DummyEnde, Projekt.DummyUhrzeit, DummyEinsatzBeschreibung, Projekt.EinsatzAnlegen, Projekt.idProjekt, Aufgabe.Aufgabe_id " +
				"FROM helfer_faehigkeit_zuordnung, faehigkeit, faehigkeit_aufgabe_zuordnung, Aufgabe, Projekt_Aufgabe_Zuordnung, Projekt " +
				"WHERE Aufgabe.Aufgabe_id = Projekt_Aufgabe_Zuordnung.Aufgabe_id " +
				"AND Projekt_Aufgabe_Zuordnung.Projekt_idProjekt = Projekt.idProjekt " +
				"AND Aufgabe.Aufgabe_id = faehigkeit_aufgabe_zuordnung.Aufgabe_id " +
				"AND faehigkeit_aufgabe_zuordnung.faehigkeit_id = faehigkeit.faehigkeit_id " +
				"AND helfer_faehigkeit_zuordnung.faehigkeit_id = faehigkeit.faehigkeit_id " +
				"AND helfer_faehigkeit_zuordnung.Helfer_natPerson_Person_person_id ="+id;
		
		return sql;
	}
	
	//Löschen eines bestimmten Einsatzes
	static boolean einsatzfuerhelferdeletesql(String id)
	{
		try{
			String sql = "Delete FROM Einsatz where Einsatz_id = "+id;
			if(!CS_DataBaseConnect.dbUpdate(sql))
				return false;	
			
			sql = "";
			sql = "Delete FROM einsatz_has_termine where Einsatz_id = "+id;
			if(!CS_DataBaseConnect.dbUpdate(sql))
				return false;
			
			return true;	
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	//Update der Fähigkeiten eines Helfers
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
	
	//Update der Notizen eines Helfer in dem Dialogfeld Dialog_HelferAnzeigen
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
	
	
	
	//Sql Abfragen zur Trägerpage------------------------------------------------------------------------------------------------------------------------------------------------------
	static String traegersql()
	{
		String sql = "";
		sql = "SELECT Traeger.name, Traeger.kontaktperson, Person.telefonnr, Person.handyNr, Person.strasse, Person.PLZ, Person.Ort, Person.eMailAdresse, Traeger.beschreibung, Traeger.Person_person_id FROM Traeger,Person WHERE Traeger.Person_person_id = Person.person_id";

		return sql;
	}
	
	//Stimmt noch nicht!
	static boolean traegeranlegensql(ArrayList<ArrayList<String>> uebergabeWerte)
	{
		try {
			String sql = "";	
			boolean firstEntry = true;
			String database = "INSERT INTO Person (";
			String values = "VALUES (";
			for(int i = 0; i<=5; i++){
				if(firstEntry)
				{
					if(!uebergabeWerte.get(i).get(1).equals("") && !uebergabeWerte.get(i).get(1).equals("''")){
						database += uebergabeWerte.get(i).get(0);
						values += uebergabeWerte.get(i).get(1);
						firstEntry = false;
					}
				}
				else
				{
					if(!uebergabeWerte.get(i).get(1).equals("") && !uebergabeWerte.get(i).get(1).equals("''")){
						database += (" ,"+uebergabeWerte.get(i).get(0));
						values += (" ,"+uebergabeWerte.get(i).get(1));						
					}
				}
				
			}
			database += ") ";
			values += ")";
			sql = database + values;
			if(!sql.equals(""))
				if(!CS_DataBaseConnect.dbUpdate(sql))
					return false;
			
			sql = "";		
			CS_DataBaseConnect.dbQuery("SELECT max(person_id) FROM Person",false);	
			DefaultTableModel model = new DefaultTableModel();
			model = CS_DataBaseConnect.getModel();
			int maxId = (Integer.parseInt(model.getValueAt(0, 0).toString()));
			
			
			
			database = "INSERT INTO Traeger (Person_person_id";
			values = "VALUES ("+maxId;
			for(int i = 6; i<uebergabeWerte.size(); i++){
				if(!uebergabeWerte.get(i).get(1).equals("") && !uebergabeWerte.get(i).get(1).equals("''")){
					database += (" ,"+uebergabeWerte.get(i).get(0));
					values += (" ,"+uebergabeWerte.get(i).get(1));				
				}
			}
			database += ") ";
			values += ")";
			sql = database + values;
			if(!sql.equals(""))
				if(!CS_DataBaseConnect.dbUpdate(sql))
					return false;
			
		}
		catch(Exception ex)
		{
			return false;
		}
		return true;	
	}
	
	
	//Sql Abfragen zur Aufgabenpage------------------------------------------------------------------------------------------------------------------------------------------
	static String aufgabensql()
	{
		String sql = "SELECT Aufgabe.name, Aufgabe.beschreibung, Aufgabe_id FROM Aufgabe";
		return sql;

	}
	
	//Zuordnung von Aufgaben und Fähigkeiten (Welche Aufgabe hat welche Fähigkeiten)
	static boolean aufgabehasfaehigkeitsql(ArrayList<String> input, String id)
	{
		try{
		String sql = "";
		sql = "DELETE FROM faehigkeit_aufgabe_zuordnung where faehigkeit_aufgabe_zuordnung.Aufgabe_id = "+id;
		if(!sql.equals(""))
			if(!CS_DataBaseConnect.dbUpdate(sql))
				return false;	
		
		sql = "";
		int t = input.size();
		for(int i = 0; i < t; i++){
			String database = "INSERT INTO faehigkeit_aufgabe_zuordnung (faehigkeit_aufgabe_zuordnung.Aufgabe_id, faehigkeit_aufgabe_zuordnung.faehigkeit_id";
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
	
	//Aufgaben anlegen
	static boolean aufgabenanlegensql(ArrayList<ArrayList<String>> uebergabeWerte)
	{
		try {
			String sql = "";	
			boolean firstEntry = true;
			String database = "INSERT INTO Aufgabe (";
			String values = "VALUES (";
			for(int i = 0; i<uebergabeWerte.size(); i++){
				if(firstEntry)
				{
					if(!uebergabeWerte.get(i).get(1).equals("") && !uebergabeWerte.get(i).get(1).equals("''")){
						database += uebergabeWerte.get(i).get(0);
						values += uebergabeWerte.get(i).get(1);
						firstEntry = false;
					}
				}
				else
				{
					if(!uebergabeWerte.get(i).get(1).equals("") && !uebergabeWerte.get(i).get(1).equals("''")){
						database += (" ,"+uebergabeWerte.get(i).get(0));
						values += (" ,"+uebergabeWerte.get(i).get(1));						
					}
				}
				
			}
			database += ") ";
			values += ")";
			sql = database + values;
			if(!sql.equals(""))
				if(!CS_DataBaseConnect.dbUpdate(sql))
					return false;
			
		}
		catch(Exception ex)
		{
			return false;
		}
		return true;	
	}
	
	//Ermitteln der angelegten Fähigkeiten zu den Aufgaben
	static String faehigkeitenzuaufgabesql(String id)
	{
		String sql = "SELECT faehigkeit.bezeichnung FROM faehigkeit, faehigkeit_aufgabe_zuordnung, Aufgabe where Aufgabe.Aufgabe_id ="+id+" AND Aufgabe.Aufgabe_id = faehigkeit_aufgabe_zuordnung.Aufgabe_id AND faehigkeit_aufgabe_zuordnung.faehigkeit_id = faehigkeit.faehigkeit_id";
		return sql;

	}
	
	//Sql Abfragen zur Fähigkeitenpage----------------------------------------------------------------------------------------------------------------------------------------------
	static String faehigkeitensql()
	{
		String sql = "SELECT faehigkeit.bezeichnung, faehigkeit.beschreibung, faehigkeit_id FROM faehigkeit";
		return sql;

	}
	
	//Angelegen von Fähigkeiten
	static boolean faehigkeitenanlegensql(ArrayList<ArrayList<String>> uebergabeWerte)
	{
		try {
			String sql = "";	
			boolean firstEntry = true;
			String database = "INSERT INTO faehigkeit (";
			String values = "VALUES (";
			for(int i = 0; i<uebergabeWerte.size(); i++){
				if(firstEntry)
				{
					if(!uebergabeWerte.get(i).get(1).equals("") && !uebergabeWerte.get(i).get(1).equals("''")){
						database += uebergabeWerte.get(i).get(0);
						values += uebergabeWerte.get(i).get(1);
						firstEntry = false;
					}
				}
				else
				{
					if(!uebergabeWerte.get(i).get(1).equals("") && !uebergabeWerte.get(i).get(1).equals("''")){
						database += (" ,"+uebergabeWerte.get(i).get(0));
						values += (" ,"+uebergabeWerte.get(i).get(1));						
					}
				}
				
			}
			database += ") ";
			values += ")";
			sql = database + values;
			if(!sql.equals(""))
				if(!CS_DataBaseConnect.dbUpdate(sql))
					return false;
			
		}
		catch(Exception ex)
		{
			return false;
		}
		return true;	
	}
	
	//Sql Abfragen zur Projektpage-------------------------------------------------------------------------------------------------------------------------------------------------
	static String projektesql()
	{
		String sql = "SELECT projektname, beschreibung, idProjekt FROM projekt";
		return sql;

	}
	//Ermittelt die Helfer, die eine bestimmte Aufgabe ausführen können (Auf Basis der erforderlichen Fähigkeiten der Aufgabe und der Fähigkeiten des Helfers)
	static String helferaufgabensql(String aufgabeid, String projektid)
	{
		String sql = "";
		
		
		sql = "Select DISTINCT natPerson.nachname, natPerson.vname, Person.eMailAdresse, Person.telefonnr, Projekt.DummyTraeger, Projekt.DummyBeginn, Projekt.DummyEnde, Projekt.DummyUhrzeit, Projekt.DummyEinsatzBeschreibung, Projekt.EinsatzAnlegen, Person.person_id  " +
				"from Person,natPerson, faehigkeit_aufgabe_zuordnung, faehigkeit, helfer_faehigkeit_zuordnung, Helfer, Aufgabe, Projekt_Aufgabe_Zuordnung, Projekt " +
				"WHERE helfer_faehigkeit_zuordnung.faehigkeit_id=faehigkeit_aufgabe_zuordnung.faehigkeit_id " +
				"AND faehigkeit_aufgabe_zuordnung.faehigkeit_id = faehigkeit.faehigkeit_id " +
				"AND faehigkeit.faehigkeit_id =  helfer_faehigkeit_zuordnung.faehigkeit_id " +
				"AND helfer_faehigkeit_zuordnung.Helfer_natPerson_Person_person_id = Helfer.natPerson_Person_person_id " +
				"AND Helfer.natPerson_Person_person_id = natPerson.Person_person_id " +
				"AND natPerson.Person_person_id = Person.person_id " +
				"AND faehigkeit_aufgabe_zuordnung.Aufgabe_id = Aufgabe.Aufgabe_id " +
				"AND Aufgabe.Aufgabe_id = Projekt_Aufgabe_Zuordnung.Aufgabe_id " +
				"AND Projekt_Aufgabe_Zuordnung.Projekt_idProjekt = Projekt.idProjekt " +
				"AND Projekt.idProjekt ="+projektid+" AND Aufgabe.Aufgabe_id ="+aufgabeid;
		
		return sql;
		
	}
	
	//Sql zum befüllen des Dialogfeld Dialog_AufgabezuProjekt, das die Aufgaben zu einem bestimmten Projekt anzeigt
	static String aufgabenzuprojektsql(String id)
	{
		String sql = "SELECT Aufgabe.name FROM Aufgabe, Projekt_Aufgabe_Zuordnung, Projekt where Projekt.idProjekt ="+id+" AND Projekt.idProjekt = Projekt_Aufgabe_Zuordnung.Projekt_idProjekt AND Projekt_Aufgabe_Zuordnung.Aufgabe_id = Aufgabe.Aufgabe_id";
		return sql;

	}
	
	
	//Sql zur Ermittlung der zu einem Projekt gehörenden Aufgaben und dem Dummyfeld "EinsatzBeschreibung", das hier lediglich als Platzhalter für den Anzeigebutton zur Helferermittlung in der Tablle dient
	static String helferzuprojektaufgabensql(String id)
	{
		String sql = "SELECT Aufgabe.name, Projekt.DummyEinsatzBeschreibung, Aufgabe.Aufgabe_id FROM Aufgabe, Projekt_Aufgabe_Zuordnung, Projekt where Projekt.idProjekt ="+id+" AND Projekt.idProjekt = Projekt_Aufgabe_Zuordnung.Projekt_idProjekt AND Projekt_Aufgabe_Zuordnung.Aufgabe_id = Aufgabe.Aufgabe_id";
		return sql;

	}
	
	//Sql zum befüllen der ComboBox zur Auswahl der Aufgaben die zu einem Projekt hinzugefügt werden können
	static String aufgabenfuercomboboxsql()
	{
		String sql = "SELECT Aufgabe.name, Aufgabe.Aufgabe_id FROM Aufgabe";
		return sql;
	}
	
	//Update zum Ändern der zum Projekt gehörenden Aufgaben
	static boolean projekthasaufgabensql(ArrayList<String> input, String id)
	{
		try{
		String sql = "";
		sql = "DELETE FROM Projekt_Aufgabe_Zuordnung where Projekt_Aufgabe_Zuordnung.Projekt_idProjekt = "+id;
		if(!sql.equals(""))
			if(!CS_DataBaseConnect.dbUpdate(sql))
				return false;	
		
		sql = "";
		int t = input.size();
		for(int i = 0; i < t; i++){
			String database = "INSERT INTO Projekt_Aufgabe_Zuordnung (Projekt_Aufgabe_Zuordnung.Projekt_idProjekt, Projekt_Aufgabe_Zuordnung.Aufgabe_id ";
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
	
	//Sql zum Anlegen eines Projektes
	static boolean projektanlegensql(ArrayList<ArrayList<String>> uebergabeWerte)
	{
		try {
			String sql = "";	
			boolean firstEntry = true;
			String database = "INSERT INTO Projekt (";
			String values = "VALUES (";
			for(int i = 0; i<uebergabeWerte.size(); i++){
				if(firstEntry)
				{
					if(!uebergabeWerte.get(i).get(1).equals("") && !uebergabeWerte.get(i).get(1).equals("''")){
						database += uebergabeWerte.get(i).get(0);
						values += uebergabeWerte.get(i).get(1);
						firstEntry = false;
					}
				}
				else
				{
					if(!uebergabeWerte.get(i).get(1).equals("") && !uebergabeWerte.get(i).get(1).equals("''")){
						database += (" ,"+uebergabeWerte.get(i).get(0));
						values += (" ,"+uebergabeWerte.get(i).get(1));						
					}
				}
				
			}
			database += ") ";
			values += ")";
			sql = database + values;
			if(!sql.equals(""))
				if(!CS_DataBaseConnect.dbUpdate(sql))
					return false;
			
		}
		catch(Exception ex)
		{
			return false;
		}
		return true;	
	}
	
	//Sql Abfragen zur Einsatzpage--------------------------------------------------------------------------------------------------------------------------------------------------
	static String einsatzsql()
	{
		String sql ="SELECT Projekt.projektname, Aufgabe.name, Traeger.name, Einsatz.EinsatzBeginn, Einsatz.EinsatzEnde, Projekt.DummyUhrzeit, concat_ws(',',natPerson.nachname, natPerson.vname) as name, Einsatz.EinsatzBeschreibung, Einsatz.Einsatz_id " +
				"FROM Einsatz, Projekt_Aufgabe_Zuordnung, Aufgabe, Projekt, Traeger_Projekt_Zuordnung, Traeger, Helfer, natPerson " +
				"WHERE Einsatz.Projekt_Aufgabe_Zuordnung_Projekt_idProjekt = Projekt_Aufgabe_Zuordnung.Projekt_idProjekt " +
				"AND Einsatz.Projekt_Aufgabe_Zuordnung_Aufgabe_id = Projekt_Aufgabe_Zuordnung.Aufgabe_id " +
				"AND Projekt_Aufgabe_Zuordnung.Aufgabe_id = Aufgabe.Aufgabe_id " +
				"AND Projekt_Aufgabe_Zuordnung.Projekt_idProjekt = Projekt.idProjekt " +
				"AND Projekt.idProjekt = Traeger_Projekt_Zuordnung.Projekt_idProjekt " +
				"AND Traeger_Projekt_Zuordnung.Traeger_Person_person_id = Traeger.Person_person_id " +
				"AND Einsatz.Helfer_natPerson_Person_person_id = Helfer.natPerson_Person_person_id " +
				"AND Helfer.natPerson_Person_person_id = natPerson.Person_person_id";
		return sql;
	}
	
	//Sql zum Dialog Dialog_Login-----------------------------------------------------------------------------------------------------------------------------------------------------
	static String passwortermittelnsql(String vName, String nName)
	{
		String sql = "";
		sql = "SELECT login.passwort FROM login, Lotse, natPerson WHERE login.Lotse_natPerson_Person_person_id = Lotse.natPerson_Person_person_id AND Lotse.natPerson_Person_person_id = natPerson.Person_person_id AND natPerson.vname = "+vName+" AND natPerson.nachname = "+nName;
		return sql;
	}
	
	

}
