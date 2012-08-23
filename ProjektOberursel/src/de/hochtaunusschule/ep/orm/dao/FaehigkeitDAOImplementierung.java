package de.hochtaunusschule.ep.orm.dao;

import java.sql.Connection;


import de.hochtaunusschule.ep.orm.dto.IFaehigkeit;

public abstract class FaehigkeitDAOImplementierung extends AbstractDAO<IFaehigkeit> implements
		IFaehigkeitDAO {
	
	public FaehigkeitDAOImplementierung(Connection databaseConnection) {
		super(databaseConnection);
		// TODO Auto-generated constructor stub
	}
}
