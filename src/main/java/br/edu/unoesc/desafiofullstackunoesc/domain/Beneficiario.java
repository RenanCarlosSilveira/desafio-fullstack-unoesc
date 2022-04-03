package br.edu.unoesc.desafiofullstackunoesc.domain;


public class Beneficiario {

	private int id_beneficiario;
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
