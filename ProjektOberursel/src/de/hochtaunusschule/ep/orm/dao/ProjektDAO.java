package de.hochtaunusschule.ep.orm.dao;

import java.sql.Connection;


//muss angepasst werden!
public abstract class ProjektDAO extends AbstractDAO<IProjektDAO> implements IProjektDAO {

	public ProjektDAO(Connection databaseConnection) {
		super(databaseConnection);
		// TODO Auto-generated constructor stub
	}

}
