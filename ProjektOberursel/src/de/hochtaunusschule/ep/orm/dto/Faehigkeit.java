package de.hochtaunusschule.ep.orm.dto;

//muss angepasst werden!
public class Faehigkeit implements IFaehigkeit 
{
	private String bezeichnung;
	private String kommentar;
	
	public Faehigkeit(String bezeichnung, String kommentar)
	{
		this.bezeichnung = bezeichnung;
		this.setKommentar(kommentar);
	}
	
	
	@Override
	public String getBezeichnung() 
	{
		return this.bezeichnung;
	}

	@Override
	public String getKommentar()
	{
		return this.kommentar;
	}

	@Override
	public void setKommentar(String kommentar) 
	{
		this.kommentar = kommentar;
	}

}