package br.edu.unoesc.desafiofullstackunoesc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "responsavelAuxilioEmergencial")
public class ResponsavelAuxilioEmergencial {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int idSQL;
	@OneToOne(mappedBy = "responsavelAuxilioEmergencial")
	public Beneficio beneficio;
	public String cpfFormatado;
	public String nis;
	public String nome;


	public ResponsavelAuxilioEmergencial() {
	}

	public String getCpfFormatado() {
		return cpfFormatado;
	}

	public void setCpfFormatado(String cpfFormatado) {
		this.cpfFormatado = cpfFormatado;
	}

	public String getNis() {
		return nis;
	}

	public void setNis(String nis) {
		this.nis = nis;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
