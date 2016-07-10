package br.org.pastoraldacrianca.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Coordenador extends GenericDomain{
	
	@OneToOne
	@JoinColumn
	private Usuario usuario;
	
	@Column(nullable = false,length = 50)
	private String nome;
	
	@Column(nullable = false,length = 50)
	private String endereco;
	
	@Column(length = 50)
	private String diocese;
	
	@Column(length = 50)
	private String paroquia;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDiocese() {
		return diocese;
	}

	public void setDiocese(String diocese) {
		this.diocese = diocese;
	}

	public String getParoquia() {
		return paroquia;
	}

	public void setParoquia(String paroquia) {
		this.paroquia = paroquia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
