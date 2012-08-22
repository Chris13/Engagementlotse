package de.hochtaunusschule.ep.orm.dto;

import java.util.Date;
import java.util.List;
import de.hochtaunusschule.ep.orm.dto.INatuerlichePerson;

//muss angepasst werden!
public interface IHelfer extends INatuerlichePerson
{
	/**
	 * Diese Methode gibt das Eintrittsdatum in der Form JJJJ-MM-TT zurueck.
	 * @return Date
	 */
	Date getEintrittsdatum();
	List<IFaehigkeit> getFaehigkeiten();
	List<IEinsatz> getEinsaetze();
	
	
	void addEinsatz(IEinsatz einsatz);
	void removeEinsatz(IEinsatz einsatz);
	void removeEinsatz(int einsatzNr);
	void addFaehigkeit(IFaehigkeit faehigkeit); //Erstellt eine Helfer-Faehigkeit-Zuordnung.
	void removeFaehigkeit(IFaehigkeit faehigkeit);
	void removeFaehigkeit(int faehigkeitenNr);

}
