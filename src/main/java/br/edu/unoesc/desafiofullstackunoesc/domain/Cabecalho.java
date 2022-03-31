package br.edu.unoesc.desafiofullstackunoesc.domain;

@SuppressWarnings("serial")
public class Cabecalho extends AbstractEntity{
	public String codibge;
	public String anoref;
	public String mesref;
	public String pag;

	public Cabecalho() {
	}

	public String getCodibge() {
		return codibge;
	}

	public void setCodibge(String codibge) {
		this.codibge = codibge;
	}

	public String getAnoref() {
		return anoref;
	}

	public void setAnoref(String anoref) {
		this.anoref = anoref;
	}

	public String getMesref() {
		return mesref;
	}

	public void setMesref(String mesref) {
		this.mesref = mesref;
	}

	public String getPag() {
		return pag;
	}

	public void setPag(String pag) {
		this.pag = pag;
	}

}
