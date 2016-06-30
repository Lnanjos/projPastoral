package br.org.pastoraldacrianca.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import br.org.pastoraldacrianca.DAO.CriancaDAO;
import br.org.pastoraldacrianca.DAO.LiderDAO;
import br.org.pastoraldacrianca.DAO.NaoAtendimentoDAO;
import br.org.pastoraldacrianca.domain.Crianca;
import br.org.pastoraldacrianca.domain.Lider;
import br.org.pastoraldacrianca.domain.NaoAtendimento;

@SuppressWarnings("serial")
public class NaoAtendimentoBean implements Serializable{
	
	private Crianca crianca;
	private Lider lider;
	private NaoAtendimento naoAtendimento;
	
	private List<Crianca> criancas;
	private List<Lider> lideres;
	private List<NaoAtendimento>naoAtendimentos;
	
	public Crianca getCrianca() {
		return crianca;
	}
	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}
	public Lider getLider() {
		return lider;
	}
	public void setLider(Lider lider) {
		this.lider = lider;
	}
	public List<Crianca> getCriancas() {
		return criancas;
	}
	public void setCriancas(List<Crianca> criancas) {
		this.criancas = criancas;
	}
	public List<Lider> getLideres() {
		return lideres;
	}
	public void setLideres(List<Lider> lideres) {
		this.lideres = lideres;
	}
	public NaoAtendimento getNaoAtendimento() {
		return naoAtendimento;
	}
	public void setNaoAtendimento(NaoAtendimento naoAtendimento) {
		this.naoAtendimento = naoAtendimento;
	}
	public List<NaoAtendimento> getNaoAtendimentos() {
		return naoAtendimentos;
	}
	public void setNaoAtendimentos(List<NaoAtendimento> naoAtendimentos) {
		this.naoAtendimentos = naoAtendimentos;
	}
	@PostConstruct
	public void listar() {
		try {
			NaoAtendimentoDAO naoAtendimentoDAO = new NaoAtendimentoDAO();
			naoAtendimentos = naoAtendimentoDAO.lista();

			CriancaDAO criancaDAO = new CriancaDAO();
			criancas = criancaDAO.lista();

			LiderDAO liderDAO = new LiderDAO();
			lideres = liderDAO.lista();
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar o registro");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			naoAtendimento = new NaoAtendimento();
		
			CriancaDAO criancaDAO = new CriancaDAO();
			criancas = criancaDAO.lista();

			LiderDAO liderDAO = new LiderDAO();
			lideres = liderDAO.lista();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar uma nova cidade");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {

			naoAtendimento.setCrianca(crianca);
			naoAtendimento.setLider(lider);

			NaoAtendimentoDAO naoAtendimentoDAO = new NaoAtendimentoDAO();
			naoAtendimentoDAO.salvar(naoAtendimento);

			naoAtendimento = new NaoAtendimento();

			CriancaDAO criancaDAO = new CriancaDAO();
			criancas = criancaDAO.lista();

			LiderDAO liderDAO = new LiderDAO();
			lideres = liderDAO.lista();

			naoAtendimentos = naoAtendimentoDAO.lista();

			Messages.addGlobalInfo("Registro salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar o registro");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			naoAtendimento = (NaoAtendimento) evento.getComponent().getAttributes().get("naoAtendimentoSelecionado");

			NaoAtendimentoDAO naoAtendimentoDAO = new NaoAtendimentoDAO();
			naoAtendimentoDAO.excluir(naoAtendimento);

			naoAtendimentos = naoAtendimentoDAO.lista();

			Messages.addGlobalInfo("Registro removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o registro");
			erro.printStackTrace();
		}
	}

	
	public void editar(ActionEvent evento) {
		try {
			naoAtendimento = (NaoAtendimento) evento.getComponent().getAttributes()
					.get("naoAtendimentoSelecionado");

			LiderDAO liderDAO = new LiderDAO();
			lideres = liderDAO.lista();

			CriancaDAO criancaDAO = new CriancaDAO();
			criancas = criancaDAO.lista();	
			
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar o registro");
		}
	}

}
