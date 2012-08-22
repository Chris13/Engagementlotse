package de.hochtaunusschule.ep.orm.dao;

import java.sql.Connection;

import de.hochtaunusschule.ep.orm.dto.ILotse;

public abstract class LotseDAOImplementierung extends AbstractDAO<ILotse> implements ILotseDAO {

	public LotseDAOImplementierung(Connection databaseConnection) {
		super(databaseConnection);
		// TODO Auto-generated constructor stub
	}
}
