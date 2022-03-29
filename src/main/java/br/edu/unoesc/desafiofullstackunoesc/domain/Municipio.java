package br.edu.unoesc.desafiofullstackunoesc.domain;

public class Municipio {

	public String codigoIBGE;
	public String codigoRegiao;
	public String nomeIBGE;
	public String nomeRegiao;
	public String pais;
    public Uf uf;
    
    public Municipio() {}

	public String getCodigoIBGE() {
		return codigoIBGE;
	}

	public void setCodigoIBGE(String codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}

	public String getCodigoRegiao() {
		return codigoRegiao;
	}

	public void setCodigoRegiao(String codigoRegiao) {
		this.codigoRegiao = codigoRegiao;
	}

	public String getNomeIBGE() {
		return nomeIBGE;
	}

	public void setNomeIBGE(String nomeIBGE) {
		this.nomeIBGE = nomeIBGE;
	}

	public String getNomeRegiao() {
		return nomeRegiao;
	}

	public void setNomeRegiao(String nomeRegiao) {
		this.nomeRegiao = nomeRegiao;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}
    
    
}
