package de.hochtaunusschule.ep.orm.dao;

import java.sql.Connection;

import de.hochtaunusschule.ep.orm.dto.IHelfer;

public abstract class HelferDAOImplementierung extends AbstractDAO <IHelfer> implements IHelferDAO
{
	public HelferDAOImplementierung(Connection databaseConnection) {
		super(databaseConnection);
		// TODO Auto-generated constructor stub
	}
}

	
