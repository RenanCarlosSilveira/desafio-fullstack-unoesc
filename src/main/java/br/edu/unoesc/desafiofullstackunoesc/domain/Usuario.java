package br.edu.unoesc.desafiofullstackunoesc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "usuario", indexes = {@Index(name = "idx_usuario_email", columnList = "email")})
public class Usuario extends AbstractEntity {	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@JsonIgnore
	@Column(name = "senha", nullable = false)
	private String senha;
		
	public Usuario() {
		super();
	}

	public Usuario(Long id) {
		super.setId(id);
	}
	
	public Usuario(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
