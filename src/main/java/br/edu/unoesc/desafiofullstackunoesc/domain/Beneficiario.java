package br.edu.unoesc.desafiofullstackunoesc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "beneficiario")
public class Beneficiario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_beneficiario;
	@OneToOne(mappedBy="beneficiario")
	private Beneficio beneficio;
	private String cpfFormatado;
	private String nis;
	private String nome;
    
    public Beneficiario() {}

	public int getId_beneficiario() {
		return id_beneficiario;
	}

	public void setId_beneficiario(int id_beneficiario) {
		this.id_beneficiario = id_beneficiario;
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
		return "BeneficiarioEntity [id_beneficiario=" + id_beneficiario + ", beneficio=" + beneficio + ", cpfFormatado="
				+ cpfFormatado + ", nis=" + nis + ", nome=" + nome + "]";
	} 
	
	

}
