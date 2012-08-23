package de.hochtaunusschule.ep.orm.dto;

import java.util.Date;

//muss angepasst werden!
public interface INotiz extends IDTO
{
	String getErstellungsDatum();
	String getText(); // Notiztext

	void setErstellungsDatum(Date datum);
	void setText(String text);
}
