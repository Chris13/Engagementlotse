package de.hochtaunusschule.ep.orm.dto;

//muss angepasst werden!
public interface IAufgabe extends IDTO
{
	String getName();
	String getBeschreibung();
	ITraeger getTraeger();
	
	void setBeschreibung(String beschreibung);
	void setTraeger(ITraeger traeger);
	
}
