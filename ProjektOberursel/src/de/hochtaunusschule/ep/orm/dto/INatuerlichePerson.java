package de.hochtaunusschule.ep.orm.dto;

import java.util.Date;

//muss angepasst werden!
public interface INatuerlichePerson extends IPerson
{
	String getVorname();
	String getNachname();
	Date getGeburtsDatum();
	boolean getGeschlecht();
	
	void setVorname(String vorname);
	void setNachname(String nachname);
	void setGeschlecht(boolean geschlecht);
}
