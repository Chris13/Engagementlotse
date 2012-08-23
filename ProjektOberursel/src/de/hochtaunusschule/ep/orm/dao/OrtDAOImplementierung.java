package de.hochtaunusschule.ep.orm.dao;

import java.sql.Connection;

import de.hochtaunusschule.ep.orm.dto.IOrt;

public abstract class OrtDAOImplementierung extends AbstractDAO<IOrt> implements IOrtDAO {

	public OrtDAOImplementierung(Connection databaseConnection) {
		super(databaseConnection);
		// TODO Auto-generated constructor stub
	}

}
