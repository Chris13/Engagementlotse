package de.hochtaunusschule.ep.orm.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import de.hochtaunusschule.ep.orm.dao.AufgabeDAOImplementierung;
import de.hochtaunusschule.ep.orm.dao.EinsatzDAOImplementierung;
import de.hochtaunusschule.ep.orm.dao.FaehigkeitDAOImplementierung;
import de.hochtaunusschule.ep.orm.dao.HelferDAOImplementierung;
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
import de.hochtaunusschule.ep.orm.dao.KontaktpersonDAOImplementierung;
import de.hochtaunusschule.ep.orm.dao.LotseDAOImplementierung;
import de.hochtaunusschule.ep.orm.dao.NatuerlichePersonDAOImplementierung;
import de.hochtaunusschule.ep.orm.dao.OrtDAOImplementierung;
import de.hochtaunusschule.ep.orm.dao.PersonDAOImplementierung;
import de.hochtaunusschule.ep.orm.dao.TraegerDAOImplementierung;


public class DatenbankVerbindung implements IDatenbankverbindung 
{
	private String jdbcConnectionString;
	private Connection con;
	private String username;
	private String password;
	
	public DatenbankVerbindung(String jdbcConnectionString, String username, String password) throws SQLException
	{
		this.jdbcConnectionString = jdbcConnectionString;
		this.username = username;
		this.password = password;
	}
	
	
	
	@Override
	public IAufgabeDAO getAufgabeDAO()
	{
		return new AufgabeDAOImplementierung(this.con);
	}
	
	@Override
	public IHelferDAO getHelferDAO()
	{
		return new HelferDAOImplementierung(this.con);
	}
	
	@Override
	public ITraegerDAO getTraegerDAO()
	{
		return new TraegerDAOImplementierung(this.con);	
	}
	
	@Override
	public IEinsatzDAO getEinsatzDAO()
	{
		return new EinsatzDAOImplementierung(this.con);
	}
	
	@Override
	public IFaehigkeitDAO getFaehigkeitDAO()
	{
		return new FaehigkeitDAOImplementierung(this.con);
	}
	
	@Override
	public IKontaktpersonDAO getKontaktpersonDAO()
	{
		return new KontaktpersonDAOImplementierung(this.con);
	}
	
	@Override
	public ILotseDAO getLotseDAO()
	{
		return new LotseDAOImplementierung(this.con);
	}
	
	@Override
	public INatuerlichePersonDAO getNatuerlichePersonDAO()
	{
		return new NatuerlichePersonDAOImplementierung(this.con);
	}
	
	@Override
	public IOrtDAO getOrtDAO()
	{
		return new OrtDAOImplementierung(this.con);
	}
	
	@Override
	public IPersonDAO getPersonDAO()
	{
		return new PersonDAOImplementierung(this.con);
	}



	@Override
	public void connect() throws SQLException {
		this.con = DriverManager.getConnection(this.jdbcConnectionString, this.username, this.password);
	}



	@Override
	public void disconnect() throws SQLException {
		this.con.close();
	}
	

}
