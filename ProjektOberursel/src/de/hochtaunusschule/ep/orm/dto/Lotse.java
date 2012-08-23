package de.hochtaunusschule.ep.orm.dto;

import java.util.Date;
import java.util.List;

//muss angepasst werden!
public class Lotse extends NatuerlichePerson
		implements ILotse {

	public Lotse(IOrt wohnort, String vorname, String nachname,
			boolean geschlecht, Date geburtsDatum) {
		super(wohnort, vorname, nachname, geschlecht, geburtsDatum);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Date getEintrittsdatum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IEinsatz> getVermittelteEinsaetze() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<INotiz> getNotizen() {
		// TODO Auto-generated method stub
		return null;
	}

}
