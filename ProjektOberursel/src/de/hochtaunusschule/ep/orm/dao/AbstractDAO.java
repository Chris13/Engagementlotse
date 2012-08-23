package de.hochtaunusschule.ep.orm.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;



abstract class AbstractDAO<T>
{
	private Connection con;
	
	public AbstractDAO(Connection databaseConnection)
	{
		this.con = databaseConnection;
	}
	
	protected CachedRowSet query(String sqlQueryString) throws SQLException
	{
		CachedRowSet cachedResult = new CachedRowSetImpl();
		Statement stmt = con.createStatement();
		cachedResult.populate(stmt.executeQuery(sqlQueryString));
		stmt.close();
		return cachedResult;
	}
	
	protected int update(String sqlUpdateString) throws SQLException
	{
		int updateResult;
		Statement stmt = con.createStatement();
		updateResult = stmt.executeUpdate(sqlUpdateString);
		stmt.close();
		return updateResult;
	}
	
	
	
//	protected abstract void update() throws SQLException;
}
