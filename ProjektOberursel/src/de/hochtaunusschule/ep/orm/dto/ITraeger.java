package de.hochtaunusschule.ep.orm.dto;

//muss angepasst werden!
public interface ITraeger extends IPerson // Traeger ist eine juristische Person
{
	String getRechtsform();
	String getName();

	void setRechtsform(String rechtsform);
	void setName(String name);
}
