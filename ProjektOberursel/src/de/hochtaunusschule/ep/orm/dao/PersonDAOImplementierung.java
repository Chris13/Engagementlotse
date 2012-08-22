package de.hochtaunusschule.ep.orm.dao;

import java.sql.Connection;

import de.hochtaunusschule.ep.orm.dto.IPerson;

public abstract class PersonDAOImplementierung extends AbstractDAO<IPerson> implements
 IPersonDAO {

	public PersonDAOImplementierung(Connection databaseConnection) {
		super(databaseConnection);
		// TODO Auto-generated constructor stub
	}

}
