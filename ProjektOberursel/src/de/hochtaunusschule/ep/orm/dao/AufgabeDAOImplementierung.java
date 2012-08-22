package de.hochtaunusschule.ep.orm.dao;

import java.sql.Connection;

import de.hochtaunusschule.ep.orm.dto.IAufgabe;


public abstract class AufgabeDAOImplementierung extends AbstractDAO<IAufgabe> implements IAufgabeDAO {

	public AufgabeDAOImplementierung(Connection databaseConnection) {
		super(databaseConnection);
		// TODO Auto-generated constructor stub
	}

}
