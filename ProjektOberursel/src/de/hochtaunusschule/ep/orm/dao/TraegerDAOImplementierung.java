package de.hochtaunusschule.ep.orm.dao;

import java.sql.Connection;
import de.hochtaunusschule.ep.orm.dto.ITraeger;

public abstract class TraegerDAOImplementierung extends AbstractDAO<ITraeger> implements
		ILotseDAO, ITraegerDAO {

	public TraegerDAOImplementierung(Connection databaseConnection) {
		super(databaseConnection);
		// TODO Auto-generated constructor stub
	}

}
