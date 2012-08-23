package de.hochtaunusschule.ep.orm.dao;

import java.sql.Connection;

import de.hochtaunusschule.ep.orm.dto.IEinsatzzeitraum;

public abstract class EinsatzzeitraumDAOImplementierung extends AbstractDAO<IEinsatzzeitraum> implements IEinsatzzeitraumDAO 
{
	public EinsatzzeitraumDAOImplementierung(Connection databaseConnection) {
		super(databaseConnection);
		// TODO Auto-generated constructor stub
	}
}
