package de.hochtaunusschule.ep.orm.dao;

import java.util.Date;
import java.util.List;

import de.hochtaunusschule.ep.orm.dto.IHelfer;

public interface ILotseDAO extends INatuerlichePersonDAO
{
	//muss angepasst werden!
	List<IHelfer> getByEintrittsDatum(Date eintrittsdatum);  //Date sollte hier sinnvollerweise ein Tag werden

}
