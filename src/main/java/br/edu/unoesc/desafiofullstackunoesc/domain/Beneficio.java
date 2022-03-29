package br.edu.unoesc.desafiofullstackunoesc.domain;

public class Beneficio {
	public Beneficiario beneficiario;
	public String enquadramentoAuxilioEmergencial;
	public String id;
	public String mesDisponibilizacao;
	public Municipio municipio;
	public String numeroParcela;
	public ResponsavelAuxilioEmergencial responsavelAuxilioEmergencial;
	public String situacaoAuxilioEmergencial;
	public String valor;

	public Beneficio() {
	}

	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public String getEnquadramentoAuxilioEmergencial() {
		return enquadramentoAuxilioEmergencial;
	}

	public void setEnquadramentoAuxilioEmergencial(String enquadramentoAuxilioEmergencial) {
		this.enquadramentoAuxilioEmergencial = enquadramentoAuxilioEmergencial;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMesDisponibilizacao() {
		return mesDisponibilizacao;
	}

	public void setMesDisponibilizacao(String mesDisponibilizacao) {
		this.mesDisponibilizacao = mesDisponibilizacao;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(String numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public ResponsavelAuxilioEmergencial getResponsavelAuxilioEmergencial() {
		return responsavelAuxilioEmergencial;
	}

	public void setResponsavelAuxilioEmergencial(ResponsavelAuxilioEmergencial responsavelAuxilioEmergencial) {
		this.responsavelAuxilioEmergencial = responsavelAuxilioEmergencial;
	}

	public String getSituacaoAuxilioEmergencial() {
		return situacaoAuxilioEmergencial;
	}

	public void setSituacaoAuxilioEmergencial(String situacaoAuxilioEmergencial) {
		this.situacaoAuxilioEmergencial = situacaoAuxilioEmergencial;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Beneficio [beneficiario=" + beneficiario + ", enquadramentoAuxilioEmergencial="
				+ enquadramentoAuxilioEmergencial + ", id=" + id + ", mesDisponibilizacao=" + mesDisponibilizacao
				+ ", municipio=" + municipio + ", numeroParcela=" + numeroParcela + ", responsavelAuxilioEmergencial="
				+ responsavelAuxilioEmergencial + ", situacaoAuxilioEmergencial=" + situacaoAuxilioEmergencial
				+ ", valor=" + valor + "]";
	}

	
}
