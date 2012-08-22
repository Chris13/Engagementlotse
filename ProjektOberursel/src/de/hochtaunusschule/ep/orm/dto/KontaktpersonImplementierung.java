package de.hochtaunusschule.ep.orm.dto;

import java.util.Date;

//muss angepasst werden!
public class KontaktpersonImplementierung extends NatuerlichePersonImplementierung implements IKontaktperson
{
	private ITraeger traeger;
	
	public KontaktpersonImplementierung(IOrt wohnort, String vorname, String nachname, boolean geschlecht, Date geburtsDatum) 
	{
		super(wohnort, vorname, nachname, geschlecht, geburtsDatum);
	}

	@Override
	public ITraeger getTraeger() 
	{
		return this.traeger;
	}

	@Override
	public void setTraeger(ITraeger traeger) 
	{
		this.traeger = traeger;
	}

}
