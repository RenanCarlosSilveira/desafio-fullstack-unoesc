package br.edu.unoesc.desafiofullstackunoesc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "uf")
public class Uf {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int idSQL;
	public String nome;
	public String sigla;
	@OneToOne(mappedBy = "uf")
	public Municipio municipio;
	
	
	public Uf() {
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

	
}
