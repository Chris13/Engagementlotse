package de.hochtaunusschule.ep.orm.dao;

import java.sql.Connection;

import de.hochtaunusschule.ep.orm.dto.IEinsatz;


public abstract class EinsatzDAOImplementierung extends AbstractDAO<IEinsatz> implements IEinsatzDAO
{
	public EinsatzDAOImplementierung(Connection databaseConnection) {
		super(databaseConnection);
		// TODO Auto-generated constructor stub
	}
}
