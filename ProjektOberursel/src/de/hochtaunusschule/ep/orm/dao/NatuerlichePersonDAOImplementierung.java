package de.hochtaunusschule.ep.orm.dao;

import java.sql.Connection;
import de.hochtaunusschule.ep.orm.dto.INatuerlichePerson;


public abstract class NatuerlichePersonDAOImplementierung extends
		AbstractDAO<INatuerlichePerson> implements INatuerlichePersonDAO {

	public NatuerlichePersonDAOImplementierung(Connection databaseConnection) {
		super(databaseConnection);
		// TODO Auto-generated constructor stub
	}

}
