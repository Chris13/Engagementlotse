package de.hochtaunusschule.ep.orm.dto;

//muss angepasst werden!
public interface IKontaktperson extends INatuerlichePerson 
{
	ITraeger getTraeger();
	
	void setTraeger(ITraeger traeger);
}
