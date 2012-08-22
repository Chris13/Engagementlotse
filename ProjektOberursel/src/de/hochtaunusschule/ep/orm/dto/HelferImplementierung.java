package de.hochtaunusschule.ep.orm.dto;

import java.util.Date;
import java.util.List;

//muss angepasst werden!
public class HelferImplementierung extends NatuerlichePersonImplementierung implements IHelfer 
{
	private Date eintrittsDatum;
	
	public HelferImplementierung(IOrt wohnort, Date heutigerTag, String vorname, String nachname, boolean geschlecht) 
	{
		super(wohnort, nachname, nachname, geschlecht, heutigerTag);
		this.eintrittsDatum = heutigerTag;
	}	
	
	@Override
	public Date getEintrittsdatum() 
	{
		return this.eintrittsDatum;
	}

	@Override
	public List<IFaehigkeit> getFaehigkeiten() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFaehigkeit(IFaehigkeit faehigkeit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFaehigkeit(IFaehigkeit faehigkeit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFaehigkeit(int faehigkeitenNr) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<IEinsatz> getEinsaetze() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEinsatz(IEinsatz einsatz) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEinsatz(IEinsatz einsatz) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEinsatz(int einsatzNr) {
		// TODO Auto-generated method stub
		
	}

}
