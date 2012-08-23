package de.hochtaunusschule.ep.orm.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T>
{
	//Create
	boolean datensatzHinzufuegen(T datensatz) throws SQLException;
	boolean datensaetzeHinzufuegen(List<T> datensaetze) throws SQLException;
	
	//Read
	T getDatensatzAnhandPrimaerSchluessel(String primaerSchluessel) throws SQLException;
	List<T> getDatensaetzeAnhandPrimaerSchluessel(List<String> primaerSchluessel) throws SQLException;
	List<T> getAlleDatensaetze() throws SQLException;
	
	//Update
	void datensatzAktualisieren(T neuerDatensatz) throws  SQLException;
	void datensaetzeAktualisieren(List<T> neueDatensaetze) throws SQLException;

	
	//Delete
	void datensatzLoeschen(T datensatz) throws SQLException;
	


	
	
}
