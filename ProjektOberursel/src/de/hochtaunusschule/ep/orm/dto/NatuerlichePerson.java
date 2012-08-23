package de.hochtaunusschule.ep.orm.dto;

import java.util.Date;

//muss angepasst werden!
public class NatuerlichePerson extends Person implements INatuerlichePerson 
{
	private String vorname;
	private String nachname;
	private Date geburtsDatum;
	private boolean geschlecht;
	
	public NatuerlichePerson(IOrt wohnort, String vorname, String nachname, boolean geschlecht, Date geburtsDatum) 
	{
		super(wohnort);
		this.vorname = vorname;
		this.nachname = nachname;
		this.geschlecht = geschlecht;
		this.geburtsDatum = geburtsDatum;
	}

	@Override
	public String getVorname() 
	{
		return this.vorname;
	}

	@Override
	public String getNachname() 
	{
		return this.nachname;
	}

	@Override
	public Date getGeburtsDatum() 
	{
		return this.geburtsDatum;
	}

	@Override
	public boolean getGeschlecht() 
	{
		return this.geschlecht;
	}

	@Override
	public void setVorname(String vorname)
	{
		this.vorname = vorname;
	}

	@Override
	public void setNachname(String nachname) 
	{
		this.nachname = nachname;
	}

	@Override
	public void setGeschlecht(boolean geschlecht) 
	{
		this.geschlecht = geschlecht;
	}
}
