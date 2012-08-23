package de.hochtaunusschule.ep.orm.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import de.hochtaunusschule.ep.orm.dto.IFaehigkeit;
import de.hochtaunusschule.ep.orm.dto.IHelfer;

public interface IHelferDAO extends INatuerlichePersonDAO
{
	//muss angepasst werden!
	List<IHelfer> getByEintrittsDatum(Date eintrittsdatum);  //Date sollte hier sinnvollerweise ein Tag werden
	List<IHelfer> getByFaehigkeit(IFaehigkeit faehigkeit);
	List<IHelfer> getByFaehigkeiten(Collection<IFaehigkeit> faehigkeiten);
}
