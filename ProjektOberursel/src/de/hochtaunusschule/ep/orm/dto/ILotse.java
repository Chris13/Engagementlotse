package de.hochtaunusschule.ep.orm.dto;

import java.util.Date;
import java.util.List;

//muss angepasst werden!
public interface ILotse extends INatuerlichePerson 
{	
	Date getEintrittsdatum();	
	List<IEinsatz> getVermittelteEinsaetze();
	List<INotiz> getNotizen();

}
