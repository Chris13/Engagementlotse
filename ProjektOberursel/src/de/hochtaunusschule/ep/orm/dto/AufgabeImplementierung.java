package de.hochtaunusschule.ep.orm.dto;

//muss angepasst werden!
public class AufgabeImplementierung implements IAufgabe {

	private String name;
	private String beschreibung;
	private ITraeger traeger;
	
	public AufgabeImplementierung(String name, ITraeger traeger)
	{
		this.name = name;
		this.traeger = traeger;
	}
	
	public AufgabeImplementierung(String name, ITraeger traeger, String beschreibung)
	{
		this.name = name;
		this.traeger = traeger;
		this.setBeschreibung(beschreibung);
	}
	
	@Override
	public String getName() 
	{
		return this.name;
	}

	@Override
	public String getBeschreibung() {
		return this.beschreibung;
	}

	@Override
	public void setBeschreibung(String beschreibung) 
	{
		this.beschreibung = beschreibung;
	}

	@Override
	public ITraeger getTraeger() {
		return this.traeger;
	}

	@Override
	public void setTraeger(ITraeger traeger) 
	{
		this.traeger = traeger;
	}

}
