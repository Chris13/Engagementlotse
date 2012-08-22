package de.hochtaunusschule.ep.orm.dbc;

import java.sql.SQLException;

import de.hochtaunusschule.ep.orm.dao.IAufgabeDAO;
import de.hochtaunusschule.ep.orm.dao.IEinsatzDAO;
import de.hochtaunusschule.ep.orm.dao.IFaehigkeitDAO;
import de.hochtaunusschule.ep.orm.dao.IHelferDAO;
import de.hochtaunusschule.ep.orm.dao.IKontaktpersonDAO;
import de.hochtaunusschule.ep.orm.dao.ILotseDAO;
import de.hochtaunusschule.ep.orm.dao.INatuerlichePersonDAO;
import de.hochtaunusschule.ep.orm.dao.IOrtDAO;
import de.hochtaunusschule.ep.orm.dao.IPersonDAO;
import de.hochtaunusschule.ep.orm.dao.ITraegerDAO;

public interface IDatenbankverbindung {

	void connect() throws SQLException;
	
	void disconnect() throws SQLException;
	
	IAufgabeDAO getAufgabeDAO();

	IHelferDAO getHelferDAO();

	ITraegerDAO getTraegerDAO();

	IEinsatzDAO getEinsatzDAO();

	IFaehigkeitDAO getFaehigkeitDAO();

	IKontaktpersonDAO getKontaktpersonDAO();

	ILotseDAO getLotseDAO();

	INatuerlichePersonDAO getNatuerlichePersonDAO();

	IOrtDAO getOrtDAO();

	IPersonDAO getPersonDAO();

}