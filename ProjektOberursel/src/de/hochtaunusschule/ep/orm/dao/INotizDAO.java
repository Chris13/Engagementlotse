package de.hochtaunusschule.ep.orm.dao;

import java.util.List;

import de.hochtaunusschule.ep.orm.dto.ILotse;
import de.hochtaunusschule.ep.orm.dto.INotiz;

public interface INotizDAO extends IDAO<INotiz> 
{
	//muss angepasst werden!
	List<INotiz> getByLotse(ILotse lotse);
}
