package br.edu.unoesc.desafiofullstackunoesc.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "uf")
public class Uf {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_uf;
	private String nome;
	private String sigla;
	@OneToMany(mappedBy = "uf", cascade = {CascadeType.MERGE})
	private List<Municipio> municipio;
	
	
	public Uf() {
	}


	public int getId_uf() {
		return id_uf;
	}


	public void setId_uf(int id_uf) {
		this.id_uf = id_uf;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSigla() {
		return sigla;
	}


	public void setSigla(String sigla) {
		this.sigla = sigla;
	}


	public List<Municipio> getMunicipio() {
		return municipio;
	}


	public void setMunicipio(List<Municipio> municipio) {
		this.municipio = municipio;
	}


	@Override
	public String toString() {
		return "UfEntity [id_uf=" + id_uf + ", nome=" + nome + ", sigla=" + sigla + ", municipio=" + municipio + "]";
	}


	
}
