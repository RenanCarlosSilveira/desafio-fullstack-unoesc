package br.edu.unoesc.desafiofullstackunoesc.domain;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("serial")
@Entity
@Table(name = "beneficio")
public class Beneficio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int idSQL;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "beneficiario_id", referencedColumnName = "idSQL")
	public Beneficiario beneficiario;
	public String enquadramentoAuxilioEmergencial;
	public String id;
	public String mesDisponibilizacao;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "municipio_id", referencedColumnName = "idSQL")
	public Municipio municipio;
	public String numeroParcela;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "responsaveleuxilioemergencial_id", referencedColumnName = "idSQL")
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

	public Beneficio(Beneficiario beneficiario, String enquadramentoAuxilioEmergencial, String id,
			String mesDisponibilizacao, Municipio municipio, String numeroParcela,
			ResponsavelAuxilioEmergencial responsavelAuxilioEmergencial, String situacaoAuxilioEmergencial,
			String valor) {
		super();
		this.beneficiario = beneficiario;
		this.enquadramentoAuxilioEmergencial = enquadramentoAuxilioEmergencial;
		this.id = id;
		this.mesDisponibilizacao = mesDisponibilizacao;
		this.municipio = municipio;
		this.numeroParcela = numeroParcela;
		this.responsavelAuxilioEmergencial = responsavelAuxilioEmergencial;
		this.situacaoAuxilioEmergencial = situacaoAuxilioEmergencial;
		this.valor = valor;
	}

}
