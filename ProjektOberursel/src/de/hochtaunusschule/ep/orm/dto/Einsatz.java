package de.hochtaunusschule.ep.orm.dto;

import java.util.Date;

//muss angepasst werden!
public class Einsatz implements IEinsatz 
{
	private IHelfer helfer;
	private ILotse lotse;
	private IAufgabe aufgabe;
	private Date beginnDatum;
	private Date endDatum;
	
	public Einsatz(IHelfer helfer, ILotse lotse, IAufgabe aufgabe)
	{
		this.helfer = helfer;
		this.aufgabe = aufgabe;
		this.lotse = lotse;
	}
	
	public Einsatz(IHelfer helfer, ILotse lotse, IAufgabe aufgabe, Date beginnDatum, Date endDatum)
	{
		this.helfer = helfer;
		this.lotse = lotse;
		this.aufgabe = aufgabe;
		this.beginnDatum = beginnDatum;
		this.endDatum = endDatum;
	}
	
	@Override
	public Date getBeginnDatum() 
	{
		return this.beginnDatum;
	}

	@Override
	public Date getEndDatum() 
	{
		return this.endDatum;
	}

	@Override
	public IAufgabe getAufgabe() 
	{
		return this.aufgabe;
	}

	@Override
	public IHelfer getHelfer() 
	{
		return this.helfer;
	}

	@Override
	public ILotse getLotse() 
	{
		return this.lotse;
	}

	@Override
	public void setBeginnDatum(Date beginnDatum) 
	{	
		this.beginnDatum = beginnDatum;
	}

	@Override
	public void setEndDatum(Date endDatum) 
	{
		this.endDatum = endDatum;
	}

	@Override
	public void setHelfer(IHelfer helfer) 
	{
		this.helfer = helfer;
	}

	@Override
	public void setLotse(ILotse lotse) 
	{
		this.lotse = lotse;
	}
}
