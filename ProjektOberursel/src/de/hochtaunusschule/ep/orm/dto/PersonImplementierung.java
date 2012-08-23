package de.hochtaunusschule.ep.orm.dto;

//muss angepasst werden!
public class PersonImplementierung implements IPerson 
{
	private int personID;
	private int telefonNr;
	private int handyNr;
	private IOrt wohnort;
	
	public PersonImplementierung(IOrt wohnort)
	{
		this.wohnort = wohnort;
	}
	
	
	@Override
	public long getPersonID() 
	{	
		return this.personID;
	}

	@Override
	public int getTelefonNr() 
	{
		return this.telefonNr;
	}

	@Override
	public IOrt getWohnort() 
	{
		return this.wohnort;
	}

	@Override
	public void setTelefonNr(int telefonNr)
	{
		this.telefonNr = telefonNr;
	}



	@Override
	public void setWohnort(IOrt wohnort)
	{
		this.wohnort = wohnort;
	}

	@Override
	public int getHandyNr() 
	{
		return this.handyNr;
	}

	@Override
	public void setHandyNr(int handyNr) 
	{
		this.handyNr = handyNr;
	}
}
