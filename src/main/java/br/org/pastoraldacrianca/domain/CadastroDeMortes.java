package br.org.pastoraldacrianca.domain;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class CadastroDeMortes extends GenericDomain {

	@OneToOne
	@JoinColumn(nullable = false)
	private Crianca crianca;	
	
	@Column(nullable = false,length = 250)
	private String causaDaMorte;
	
	@Column(nullable = false,length = 250)
	private String descricao;
	
	@Column(nullable = false,length = 250)
	private boolean assistenciaMedica;
	
	@Column(nullable = false)
	private Date dataCadastro;
	
	@Column(nullable = false)
	private Date dataMorte;
	
	public Crianca getCrianca() {
		return crianca;
	}

	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}

	public String getCausaDaMorte() {
		return causaDaMorte;
	}

	public void setCausaDaMorte(String causaDaMorte) {
		this.causaDaMorte = causaDaMorte;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isAssistenciaMedica() {
		return assistenciaMedica;
	}

	public void setAssistenciaMedica(boolean assistenciaMedica) {
		this.assistenciaMedica = assistenciaMedica;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataMorte() {
		return dataMorte;
	}

	public void setDataMorte(Date dataMorte) {
		this.dataMorte = dataMorte;
	}	
	
}
