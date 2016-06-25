package br.org.pastoraldacrianca.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Visita extends GenericDomain {

	@Column(nullable = false)
	private Date dataVisita;

	@Column(nullable = false, precision = 5, scale = 3)
	private BigDecimal peso;

	@Column(nullable = false,length = 12)
	private String atendimento;

	@Column(length = 250)
	private String observacao;
	// campo destinado para anotação sobre doenças, indicadores de
	// conquistas,vacinas e etc.

	@ManyToOne
	@JoinColumn(nullable = false)
	private Lider lider;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Crianca crianca;

	public Date getDataVisita() {
		return dataVisita;
	}

	public void setDataVisita(Date dataVisita) {
		this.dataVisita = dataVisita;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(String atendimento) {
		this.atendimento = atendimento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Lider getLider() {
		return lider;
	}

	public void setLider(Lider lider) {
		this.lider = lider;
	}

	public Crianca getCrianca() {
		return crianca;
	}

	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}

}
