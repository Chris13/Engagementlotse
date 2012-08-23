package de.hochtaunusschule.ep.orm.dto;

//muss angepasst werden!
public interface IPerson extends IDTO {
	
	long getPersonID();
	int getHandyNr();
	int getTelefonNr();
	IOrt getWohnort();
	
	void setTelefonNr(int telefonNr);
	void setHandyNr(int handyNr);
	void setWohnort(IOrt wohnort);
}
