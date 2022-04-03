package br.edu.unoesc.desafiofullstackunoesc.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "municipio")
public class Municipio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_municipio;
	private String codigoIBGE;
	private String codigoRegiao;
	private String nomeIBGE;
	private String nomeRegiao;
	private String pais;
	@OneToOne(mappedBy = "municipio")
	private Beneficio beneficio;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_uf")
	private Uf uf;

	public Municipio() {
	}

	public int getId_municipio() {
		return id_municipio;
	}

	public void setId_municipio(int id_municipio) {
		this.id_municipio = id_municipio;
	}

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

	public Beneficio getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "MunicipioEntity [id_municipio=" + id_municipio + ", codigoIBGE=" + codigoIBGE + ", codigoRegiao="
				+ codigoRegiao + ", nomeIBGE=" + nomeIBGE + ", nomeRegiao=" + nomeRegiao + ", pais=" + pais
				+ ", beneficio=" + beneficio + ", uf=" + uf + "]";
	}

	

}
