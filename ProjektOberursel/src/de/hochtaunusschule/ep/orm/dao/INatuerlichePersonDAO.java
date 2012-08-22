package de.hochtaunusschule.ep.orm.dao;

import java.util.Date;
import java.util.List;

import de.hochtaunusschule.ep.orm.dto.INatuerlichePerson;

public interface INatuerlichePersonDAO extends IPersonDAO
{
	//muss angepasst werden!
	INatuerlichePerson getByVorname(String vorname);
	INatuerlichePerson getByNachname(String nachname);
	List<INatuerlichePerson> getByGeburtsDatum(Date geburtsDatum); //Datum sollte sinnvollerweise ein Tag sein.
}
