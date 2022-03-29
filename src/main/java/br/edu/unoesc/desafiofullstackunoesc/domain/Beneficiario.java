package br.edu.unoesc.desafiofullstackunoesc.domain;

public class Beneficiario {
	public String cpfFormatado;
	public String nis;
    public String nome;
    
    public Beneficiario() {}
	
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
		return "Beneficiario [cpfFormatado=" + cpfFormatado + ", nis=" + nis + ", nome=" + nome + "]";
	}


    
}
