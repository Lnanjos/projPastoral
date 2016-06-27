package br.org.pastoraldacrianca.domain;

import javax.persistence.Column;
import javax.persistence.Entity;


@SuppressWarnings("serial")
@Entity
public class Lider extends GenericDomain{

	@Column(nullable = false,length = 50)
	private String nome;
	
	@Column(nullable = false,length = 32)
	private String senha;
	
	@Column(nullable = false,length = 50)
	private String email;
	
	@Column(nullable = false,length = 50)
	private String endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
