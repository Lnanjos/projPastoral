package br.org.pastoraldacrianca.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain{

	@Column(nullable = false,length = 32)
	private String senha;
	
	@Column(nullable = false,length = 50, unique = true)
	private String email;
	
	@Column(nullable = false)
	private Character tipo;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}
}
