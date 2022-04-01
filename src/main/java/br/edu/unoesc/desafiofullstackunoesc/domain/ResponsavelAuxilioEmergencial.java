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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_responsavelAuxilioEmergencial;
	@OneToOne(mappedBy = "responsavelAuxilioEmergencial")
	private Beneficio beneficio;
	private String cpfFormatado;
	private String nis;
	private String nome;

	public ResponsavelAuxilioEmergencial() {
	}

	public int getId_responsavelAuxilioEmergencial() {
		return id_responsavelAuxilioEmergencial;
	}

	public void setId_responsavelAuxilioEmergencial(int id_responsavelAuxilioEmergencial) {
		this.id_responsavelAuxilioEmergencial = id_responsavelAuxilioEmergencial;
	}

	public Beneficio getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
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

	@Override
	public String toString() {
		return "ResponsavelAuxilioEmergencialEntity [id_responsavelAuxilioEmergencial="
				+ id_responsavelAuxilioEmergencial + ", beneficio=" + beneficio + ", cpfFormatado=" + cpfFormatado
				+ ", nis=" + nis + ", nome=" + nome + "]";
	}

}
