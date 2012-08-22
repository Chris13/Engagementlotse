package de.hochtaunusschule.ep.orm.dto;

import java.util.Date;

//muss angepasst werden!
public interface IEinsatz extends IDTO
{
	Date getBeginnDatum();
	Date getEndDatum();
	IAufgabe getAufgabe();
	IHelfer getHelfer();  //Jeder Einsatz hat nur einen Helfer. Jede Aufgabe hat mehrere Einsätze (jeweils mindestens einen Einsatz pro Helfer; falls ein Helfer an mehreren Terminen fuer die Aufgabe eingesetzt wird, gibt es zu diesem Helfer mehrere Einsaetze fuer diese Aufgabe).
	ILotse getLotse(); //Der Engagementlotse von dem der Einsatz vermittelt wurde.
	
	void setBeginnDatum(Date beginnDatum);
	void setEndDatum(Date endDatum);
	void setHelfer(IHelfer helfer);
//	void setAufgabe(Aufgabe aufgabe);
	void setLotse(ILotse lotse);
}
