package de.hochtaunusschule.ep.orm.dao;

import java.util.List;

import de.hochtaunusschule.ep.orm.dto.IPerson;

public interface IPersonDAO extends IDAO<IPerson> 
{
	//muss angepasst werden!
	List<IPerson> getByTelefonNr(int telefonNr);
	List<IPerson> getByPLZ(int plz);
	List<IPerson> getByStrasse(String strasse);
	List<IPerson> getByWohnort(String wohnort);
}
