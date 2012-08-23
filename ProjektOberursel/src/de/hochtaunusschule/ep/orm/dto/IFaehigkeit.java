package de.hochtaunusschule.ep.orm.dto;

//muss angepasst werden!
public interface IFaehigkeit extends IDTO
{
	String getBezeichnung();
	String getKommentar();

	
	void setKommentar(String kommentar);
}
