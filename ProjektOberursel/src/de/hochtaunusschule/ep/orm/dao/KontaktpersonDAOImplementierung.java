package de.hochtaunusschule.ep.orm.dao;

import java.sql.Connection;
import de.hochtaunusschule.ep.orm.dto.IKontaktperson;


public abstract class KontaktpersonDAOImplementierung extends AbstractDAO<IKontaktperson> implements
		IKontaktpersonDAO {

	public KontaktpersonDAOImplementierung(Connection databaseConnection) {
		super(databaseConnection);
		// TODO Auto-generated constructor stub
	}
}
