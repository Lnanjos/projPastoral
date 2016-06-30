package br.org.pastoraldacrianca.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class NaoAtendimento {
	
	@Column(nullable = false)
	private Date dataNA;
	//campo para a data em que a criança nao foi atendida.
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Lider lider;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Crianca crianca;
	
	@Column(length = 250)
	private String encaminhado;
	// campo destinado para anotação do local pra o qual 
	//a criança foi encaminhada quando foi atendida.
	
	@Column(length = 250)
	private String respAt;
	//campo destinado para inserir o nome da pessoa responsavel pelo atendimento no dia
	
	@Column(length = 250)
	private String motivoNaoAT;
	//campo destinado para inserir o motivo de não atendimento da criança no SUS
	
	@Column(length = 250)
	private String sintoma;

	public Date getDataNA() {
		return dataNA;
	}

	public void setDataNA(Date dataNA) {
		this.dataNA = dataNA;
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

	public String getEncaminhado() {
		return encaminhado;
	}

	public void setEncaminhado(String encaminhado) {
		this.encaminhado = encaminhado;
	}

	public String getRespAt() {
		return respAt;
	}

	public void setRespAt(String respAt) {
		this.respAt = respAt;
	}

	public String getMotivoNaoAT() {
		return motivoNaoAT;
	}

	public void setMotivoNaoAT(String motivoNaoAT) {
		this.motivoNaoAT = motivoNaoAT;
	}

	public String getSintoma() {
		return sintoma;
	}

	public void setSintoma(String sintoma) {
		this.sintoma = sintoma;
	}
	
	
	
	


}
