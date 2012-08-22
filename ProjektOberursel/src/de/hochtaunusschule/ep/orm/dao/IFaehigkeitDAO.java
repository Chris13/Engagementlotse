package de.hochtaunusschule.ep.orm.dao;

import de.hochtaunusschule.ep.orm.dto.IFaehigkeit;

public interface IFaehigkeitDAO extends IDAO<IFaehigkeit>
{
	//muss angepasst werden!
	IFaehigkeit getByBezeichnung(String bezeichnung);
}
