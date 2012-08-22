package de.hochtaunusschule.ep.orm.dao;

import java.util.Collection;
import java.util.List;
import de.hochtaunusschule.ep.orm.dto.IFaehigkeit;
import de.hochtaunusschule.ep.orm.dto.IAufgabe;

public interface IAufgabeDAO extends IDAO<IAufgabe> 
{
	//muss angepasst werden!
	IAufgabe getByName(String name);
	List<IAufgabe> getByFaehigkeit(List<IFaehigkeit> faehigkeiten);
	List<IAufgabe> getByFaehigkeiten(Collection<IFaehigkeit> faehigkeiten);
	
}
