package br.edu.unoesc.desafiofullstackunoesc.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
@Table(name = "beneficio")
public class Beneficio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_beneficio;
	private String enquadramentoAuxilioEmergencial;
	private String id;
	private String mesDisponibilizacao;
	private String numeroParcela;
	private String situacaoAuxilioEmergencial;
	private String valor;
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "dataconsulta", nullable = false, columnDefinition = "DATE")
	private LocalDateTime dataconsulta;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "municipio_id", referencedColumnName = "id_municipio")
	private Municipio municipio;
	@Transient
	private ResponsavelAuxilioEmergencial responsavelAuxilioEmergencial;
	@Transient
	private Beneficiario beneficiario;

	public Beneficio() {
	}

	public LocalDateTime getDataconsulta() {
		return dataconsulta;
	}

	public void setDataconsulta(LocalDateTime dataconsulta) {
		this.dataconsulta = dataconsulta;
	}

	public int getId_beneficio() {
		return id_beneficio;
	}

	public void setId_beneficio(int id_beneficio) {
		this.id_beneficio = id_beneficio;
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
		return "BeneficioEntity [id_beneficio=" + id_beneficio + ", beneficiario=" + beneficiario
				+ ", enquadramentoAuxilioEmergencial=" + enquadramentoAuxilioEmergencial + ", id=" + id
				+ ", mesDisponibilizacao=" + mesDisponibilizacao + ", municipio=" + municipio + ", numeroParcela="
				+ numeroParcela + ", responsavelAuxilioEmergencial=" + responsavelAuxilioEmergencial
				+ ", situacaoAuxilioEmergencial=" + situacaoAuxilioEmergencial + ", valor=" + valor + "]";
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

	@Transient
	public String toCSV() {
		return String.format("%s;%s;%s;%s;%s;%s;%s;%s;",getId(),
				getBeneficiario().getNome(),
				getEnquadramentoAuxilioEmergencial(),
				getMesDisponibilizacao(),
				getMunicipio().getUf().getNome(),
				getMunicipio().getNomeIBGE(),
				getNumeroParcela(), 
				getValor());
	}

}
