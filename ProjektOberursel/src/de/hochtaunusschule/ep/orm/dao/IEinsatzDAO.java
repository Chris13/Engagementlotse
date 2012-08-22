package de.hochtaunusschule.ep.orm.dao;

import java.util.List;

import de.hochtaunusschule.ep.orm.dto.IAufgabe;
import de.hochtaunusschule.ep.orm.dto.IEinsatz;
import de.hochtaunusschule.ep.orm.dto.IHelfer;
import de.hochtaunusschule.ep.orm.dto.ILotse;

public interface IEinsatzDAO extends IDAO<IEinsatz> 
{
	//muss angepasst werden!
	IEinsatz getByHelfer(IHelfer helfer);
	List<IEinsatz> getByAufgabe(IAufgabe aufgabe);
	List<IEinsatz> getByLotse(ILotse lotse);
}
