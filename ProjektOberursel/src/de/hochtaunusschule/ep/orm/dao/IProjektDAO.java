package de.hochtaunusschule.ep.orm.dao;

import de.hochtaunusschule.ep.orm.dto.IProjekt;

//muss angepasst werden!
public interface IProjektDAO extends IDAO<IProjekt> 
{
	IProjekt getByName(String name);

}
