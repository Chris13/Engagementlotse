package de.hochtaunusschule.ep.orm.dao;

import java.sql.Connection;

import de.hochtaunusschule.ep.orm.dto.ILogin;

public abstract class LoginDAOImplementierung extends AbstractDAO<ILogin> implements ILoginDAO 
{
	public LoginDAOImplementierung(Connection databaseConnection) {
		super(databaseConnection);
		// TODO Auto-generated constructor stub
	}
}
