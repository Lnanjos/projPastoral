package br.org.pastoraldacrianca.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Crianca extends GenericDomain{
	
	@Column(nullable = false,length = 50)
	private String nome;
	
	@Column(nullable = false, length = 18)
	private String numSUS;
	
	@Column(nullable = false,length = 50)
	private String nomeMae;
	
	@Column(nullable = false,length = 50)
	private String endereco;
	
	@Column(nullable = false)
	private Date dataNascimento;
	
	@Column(nullable = false, precision = 5, scale = 3)
	private BigDecimal pesoNascimento;
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public BigDecimal getPesoNascimento() {
		return pesoNascimento;
	}

	public void setPesoNascimento(BigDecimal pesoNascimento) {
		this.pesoNascimento = pesoNascimento;
	}

	public String getNumSUS() {
		return numSUS;
	}

	public void setNumSUS(String numSUS) {
		this.numSUS = numSUS;
	}
}
