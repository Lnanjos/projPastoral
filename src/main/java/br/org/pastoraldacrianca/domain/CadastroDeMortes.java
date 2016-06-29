package br.org.pastoraldacrianca.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@SuppressWarnings("serial")
@Entity
public class CadastroDeMortes extends GenericDomain {

	@JoinColumn(nullable = false)
	private Crianca crianca;	
	
	@Column(nullable = false,length = 250)
	private String causaDaMorte;
	
	@Column(nullable = false,length = 250)
	private String descricao;
	
	@Column(nullable = false,length = 250)
	private boolean assistenciaMedica;
	

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
	
	
}
