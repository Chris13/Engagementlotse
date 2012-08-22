package de.hochtaunusschule.ep.orm.dao;

import java.util.List;

import de.hochtaunusschule.ep.orm.dto.IAufgabe;
import de.hochtaunusschule.ep.orm.dto.ITraeger;

public interface ITraegerDAO extends IPersonDAO
{
	//muss angepasst werden!
	List<ITraeger> getByRechtsform();
	ITraeger getByName();
	List<ITraeger> getByAufgabe(IAufgabe aufgabe);
}
